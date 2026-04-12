package com.example.umnapps;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

/**
 * Helper class untuk menambahkan animasi fade-in + slide-up
 * pada child views saat di-scroll ke viewport.
 */
public class ScrollAnimHelper {

    private static final long ANIM_DURATION = 400;
    private static final float SLIDE_DISTANCE = 60f;

    /**
     * Pasang scroll animation pada ScrollView.
     * Semua direct children dari container pertama di dalam ScrollView
     * akan di-animate saat masuk ke viewport.
     */
    public static void attach(ScrollView scrollView) {
        if (scrollView == null) return;
        if (scrollView.getChildCount() == 0) return;

        View child = scrollView.getChildAt(0);
        if (!(child instanceof ViewGroup)) return;

        ViewGroup container = findDeepestLinearLayout((ViewGroup) child);
        if (container == null) container = (ViewGroup) child;

        // Set semua children invisible awalnya
        final ViewGroup finalContainer = container;
        for (int i = 0; i < finalContainer.getChildCount(); i++) {
            View v = finalContainer.getChildAt(i);
            v.setAlpha(0f);
            v.setTranslationY(SLIDE_DISTANCE);
        }

        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        scrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        // Animate items already visible
                        animateVisibleChildren(scrollView, finalContainer);
                    }
                }
        );

        scrollView.getViewTreeObserver().addOnScrollChangedListener(
                () -> animateVisibleChildren(scrollView, finalContainer)
        );
    }

    private static final String TAG_ANIMATED = "scroll_anim_done";

    private static void animateVisibleChildren(ScrollView scrollView, ViewGroup container) {
        int scrollViewHeight = scrollView.getHeight();

        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);
            if (TAG_ANIMATED.equals(child.getTag())) continue; // Already animated

            // Check if child is in viewport (with some offset for early trigger)
            int[] location = new int[2];
            child.getLocationInWindow(location);
            int[] scrollLocation = new int[2];
            scrollView.getLocationInWindow(scrollLocation);

            int childTopInScroll = location[1] - scrollLocation[1];

            if (childTopInScroll < scrollViewHeight + 50) {
                child.setTag(TAG_ANIMATED);
                long delay = Math.max(0, i * 60L);
                child.animate()
                        .alpha(1f)
                        .translationY(0f)
                        .setDuration(ANIM_DURATION)
                        .setStartDelay(delay)
                        .setInterpolator(new android.view.animation.DecelerateInterpolator())
                        .start();
            }
        }
    }

    private static ViewGroup findDeepestLinearLayout(ViewGroup parent) {
        // Find the first LinearLayout that has more than 2 children (the content container)
        if (parent instanceof android.widget.LinearLayout && parent.getChildCount() > 2) {
            return parent;
        }
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                ViewGroup result = findDeepestLinearLayout((ViewGroup) child);
                if (result != null) return result;
            }
        }
        return null;
    }
}



