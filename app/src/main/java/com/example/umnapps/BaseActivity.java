package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Base activity yang memberikan animasi transisi otomatis
 * dan scroll animation ke semua activity yang meng-extend class ini.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Animasi masuk saat activity dibuka
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Auto-attach scroll animation jika ada ScrollView di layout
        ScrollView scrollView = findScrollView();
        if (scrollView != null) {
            ScrollAnimHelper.attach(scrollView);
        }
    }

    private ScrollView findScrollView() {
        android.view.View root = getWindow().getDecorView().findViewById(android.R.id.content);
        if (root instanceof android.view.ViewGroup) {
            return findScrollViewRecursive((android.view.ViewGroup) root, 0);
        }
        return null;
    }

    private ScrollView findScrollViewRecursive(android.view.ViewGroup parent, int depth) {
        if (depth > 4) return null; // Limit depth
        for (int i = 0; i < parent.getChildCount(); i++) {
            android.view.View child = parent.getChildAt(i);
            if (child instanceof ScrollView) return (ScrollView) child;
            if (child instanceof android.view.ViewGroup) {
                ScrollView result = findScrollViewRecursive((android.view.ViewGroup) child, depth + 1);
                if (result != null) return result;
            }
        }
        return null;
    }

    @Override
    public void finish() {
        super.finish();
        // Animasi keluar saat activity ditutup
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
