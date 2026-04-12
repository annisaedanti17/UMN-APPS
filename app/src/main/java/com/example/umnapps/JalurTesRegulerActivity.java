package com.example.umnapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JalurTesRegulerActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalur_tes_reguler);

        ImageView btnBack = findViewById(R.id.btnBack);
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);

        if (btnBack != null) btnBack.setOnClickListener(v -> finish());

        if (navHome != null) navHome.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        if (navProfil != null) navProfil.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfilActivity.class));
        });

        if (navFakultas != null) navFakultas.setOnClickListener(v -> {
            startActivity(new Intent(this, FakultasActivity.class));
        });

        if (navFasilitas != null) navFasilitas.setOnClickListener(v -> {
            startActivity(new Intent(this, FasilitasActivity.class));
        });

        // Warna orange pada "Tes Reguler" di judul
        setupJudulTesReguler();

        // Hyperlink pada "Formulir Online"
        setupFormulirOnlineLink();

        // Fitur zoom popup pada gambar
        setupZoomableImages();
    }

    private void setupJudulTesReguler() {
        TextView txtJudul = findViewById(R.id.txtJudulTesReguler);
        if (txtJudul == null) return;

        String fullText = "Jalur Pendaftaran Tes Reguler";
        String orangeText = "Tes Reguler";
        int start = fullText.indexOf(orangeText);
        int end = start + orangeText.length();

        SpannableString spannable = new SpannableString(fullText);
        spannable.setSpan(new ForegroundColorSpan(0xFFFF7C00),
                start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtJudul.setText(spannable);
    }

    private void setupFormulirOnlineLink() {
        TextView txtFormulir = findViewById(R.id.txtFormulirOnline);
        if (txtFormulir == null) return;

        String fullText = "2. Pendaftaran: Formulir Online";
        String linkText = "Formulir Online";
        int start = fullText.indexOf(linkText);
        int end = start + linkText.length();

        SpannableString spannable = new SpannableString(fullText);

        // Clickable link
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://pmb.umn.ac.id/"));
                startActivity(browserIntent);
            }

            @Override
            public void updateDrawState(android.text.TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(0xFF0077B6); // Warna biru link
                ds.setUnderlineText(true);
            }
        }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtFormulir.setText(spannable);
        txtFormulir.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void setupZoomableImages() {
        ImageView imgCatatan = findViewById(R.id.imgCatatanBagi);
        if (imgCatatan != null) {
            ImagePopupHelper.makeZoomable(this, imgCatatan);
        }
    }
}
