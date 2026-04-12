package com.example.umnapps;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Helper class untuk menampilkan gambar dalam dialog fullscreen
 * dengan kemampuan pinch-to-zoom dan double-tap-to-zoom.
 */
public class ImagePopupHelper {

    /**
     * Menampilkan popup fullscreen dari sebuah ImageView yang di-klik.
     * Gambar bisa di-zoom dengan pinch atau double-tap.
     *
     * @param context Context activity
     * @param sourceImageView ImageView sumber yang akan ditampilkan
     */
    public static void show(Context context, ImageView sourceImageView) {
        Drawable drawable = sourceImageView.getDrawable();
        if (drawable == null) return;

        Dialog dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);

        // Root layout dengan background semi-transparan gelap
        FrameLayout rootLayout = new FrameLayout(context);
        rootLayout.setBackgroundColor(Color.parseColor("#E6000000")); // 90% opacity black
        rootLayout.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        // Zoomable image
        ZoomableImageView zoomableImage = new ZoomableImageView(context);
        zoomableImage.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        Drawable.ConstantState cs = drawable.getConstantState();
        if (cs != null) {
            zoomableImage.setImageDrawable(cs.newDrawable().mutate());
        } else {
            zoomableImage.setImageDrawable(drawable);
        }

        // Close button (X) di pojok kanan atas
        ImageView closeButton = new ImageView(context);
        FrameLayout.LayoutParams closeParams = new FrameLayout.LayoutParams(
                dpToPx(context, 40),
                dpToPx(context, 40));
        closeParams.gravity = Gravity.TOP | Gravity.END;
        closeParams.topMargin = dpToPx(context, 45);
        closeParams.rightMargin = dpToPx(context, 20);
        closeButton.setLayoutParams(closeParams);
        closeButton.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        closeButton.setColorFilter(Color.WHITE);
        closeButton.setPadding(
                dpToPx(context, 8),
                dpToPx(context, 8),
                dpToPx(context, 8),
                dpToPx(context, 8));
        closeButton.setBackground(createCircleBackground());
        closeButton.setElevation(dpToPx(context, 4));
        closeButton.setClickable(true);
        closeButton.setFocusable(true);

        // Hint text "Pinch untuk zoom • Tap 2x untuk reset"
        android.widget.TextView hintText = new android.widget.TextView(context);
        FrameLayout.LayoutParams hintParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        hintParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        hintParams.bottomMargin = dpToPx(context, 30);
        hintText.setLayoutParams(hintParams);
        hintText.setText("Pinch untuk zoom  •  Tap 2x untuk reset");
        hintText.setTextColor(Color.parseColor("#99FFFFFF")); // 60% white
        hintText.setTextSize(12);

        // Add views
        rootLayout.addView(zoomableImage);
        rootLayout.addView(closeButton);
        rootLayout.addView(hintText);

        dialog.setContentView(rootLayout);

        // Close on button click
        closeButton.setOnClickListener(v -> dialog.dismiss());

        // Make dialog fullscreen
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            // Hide system bars for immersive experience (API 30+)
            WindowInsetsController controller = window.getInsetsController();
            if (controller != null) {
                controller.hide(android.view.WindowInsets.Type.systemBars());
                controller.setSystemBarsBehavior(
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        }

        // Fade-in hint lalu hilangkan setelah 3 detik
        hintText.setAlpha(0f);
        hintText.animate().alpha(1f).setDuration(300).start();
        hintText.postDelayed(() -> hintText.animate().alpha(0f).setDuration(500).start(), 3000);

        dialog.show();
    }

    /**
     * Buat click listener untuk ImageView agar bisa popup zoom.
     */
    public static void makeZoomable(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setOnClickListener(v -> show(context, imageView));
    }

    private static int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private static android.graphics.drawable.GradientDrawable createCircleBackground() {
        android.graphics.drawable.GradientDrawable shape = new android.graphics.drawable.GradientDrawable();
        shape.setShape(android.graphics.drawable.GradientDrawable.OVAL);
        shape.setColor(Color.parseColor("#66000000")); // semi-transparent black
        return shape;
    }
}




