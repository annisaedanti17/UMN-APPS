package com.example.umnapps;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logoUmn = findViewById(R.id.logo_umn);
        TextView tvUmn = findViewById(R.id.tv_umn);
        TextView tvQuote = findViewById(R.id.tv_quote);
        Button btnGetStarted = findViewById(R.id.btnGetStarted);

        // Set semua invisible dulu
        logoUmn.setAlpha(0f);
        logoUmn.setScaleX(0.6f);
        logoUmn.setScaleY(0.6f);
        tvUmn.setAlpha(0f);
        tvUmn.setTranslationY(30f);
        tvQuote.setAlpha(0f);
        tvQuote.setTranslationY(40f);
        btnGetStarted.setAlpha(0f);
        btnGetStarted.setTranslationY(50f);

        // Logo: scale up + fade in
        AnimatorSet logoAnim = new AnimatorSet();
        logoAnim.playTogether(
                ObjectAnimator.ofFloat(logoUmn, View.ALPHA, 0f, 1f),
                ObjectAnimator.ofFloat(logoUmn, View.SCALE_X, 0.6f, 1f),
                ObjectAnimator.ofFloat(logoUmn, View.SCALE_Y, 0.6f, 1f)
        );
        logoAnim.setDuration(600);
        logoAnim.setInterpolator(new DecelerateInterpolator());

        // Title: fade in + slide up
        AnimatorSet titleAnim = new AnimatorSet();
        titleAnim.playTogether(
                ObjectAnimator.ofFloat(tvUmn, View.ALPHA, 0f, 1f),
                ObjectAnimator.ofFloat(tvUmn, View.TRANSLATION_Y, 30f, 0f)
        );
        titleAnim.setDuration(500);
        titleAnim.setStartDelay(300);
        titleAnim.setInterpolator(new DecelerateInterpolator());

        // Quote: fade in + slide up
        AnimatorSet quoteAnim = new AnimatorSet();
        quoteAnim.playTogether(
                ObjectAnimator.ofFloat(tvQuote, View.ALPHA, 0f, 1f),
                ObjectAnimator.ofFloat(tvQuote, View.TRANSLATION_Y, 40f, 0f)
        );
        quoteAnim.setDuration(500);
        quoteAnim.setStartDelay(550);
        quoteAnim.setInterpolator(new DecelerateInterpolator());

        // Button: fade in + slide up
        AnimatorSet btnAnim = new AnimatorSet();
        btnAnim.playTogether(
                ObjectAnimator.ofFloat(btnGetStarted, View.ALPHA, 0f, 1f),
                ObjectAnimator.ofFloat(btnGetStarted, View.TRANSLATION_Y, 50f, 0f)
        );
        btnAnim.setDuration(500);
        btnAnim.setStartDelay(750);
        btnAnim.setInterpolator(new DecelerateInterpolator());

        // Play all
        AnimatorSet masterAnim = new AnimatorSet();
        masterAnim.playTogether(logoAnim, titleAnim, quoteAnim, btnAnim);
        masterAnim.start();

        // Navigate to HomeActivity
        btnGetStarted.setOnClickListener(v -> {
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        });
    }
}
