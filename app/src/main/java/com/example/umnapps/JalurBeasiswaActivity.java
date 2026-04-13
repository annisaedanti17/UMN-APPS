package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class JalurBeasiswaActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalur_beasiswa);

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

        if (navProfil != null) navProfil.setOnClickListener(v ->
                startActivity(new Intent(this, ProfilActivity.class)));

        if (navFakultas != null) navFakultas.setOnClickListener(v ->
                startActivity(new Intent(this, FakultasActivity.class)));

        if (navFasilitas != null) navFasilitas.setOnClickListener(v ->
                startActivity(new Intent(this, FasilitasActivity.class)));

        // Fitur zoom popup untuk semua gambar konten
        setupZoomableImages();
    }

    private void setupZoomableImages() {
        int[] imageIds = {
                R.id.imgJadwalTes,
                R.id.imgPersyaratanBeasiswa,
                R.id.imgTesTambahanKhusus,
                R.id.imgInformasiPendaftaran,
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

