package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class JalurAkademikActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalur_akademik);

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

        // Pasang fitur zoom popup untuk semua gambar konten
        setupZoomableImages();
    }

    private void setupZoomableImages() {
        int[] imageIds = {
                R.id.imgBannerPendaftaran,
                R.id.imgPersyaratanAkademik,
                R.id.imgPersyaratanDkv,
                R.id.imgPersyaratanFilm,
                R.id.imgPersyaratanHotel,
                R.id.imgProsedurPendaftaran,
                R.id.imgCatatanBagi
        };

        for (int id : imageIds) {
            ImageView img = findViewById(id);
            if (img != null) {
                ImagePopupHelper.makeZoomable(this, img);
            }
        }
    }
}
