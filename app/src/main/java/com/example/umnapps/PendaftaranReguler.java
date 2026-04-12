package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class PendaftaranReguler extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_reguler);

        // Inisialisasi Tombol Navigasi Bawah
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);
        ImageView btnBack = findViewById(R.id.btnBack);

        // Inisialisasi Tombol Jalur Pendaftaran
        ImageView btnJalurAkademik = findViewById(R.id.btnJalurAkademik);
        ImageView btnTesBeasiswa = findViewById(R.id.btnTesBeasiswa);
        ImageView btnJalurBeasiswa = findViewById(R.id.btnJalurBeasiswa);
        ImageView btnTesReguler = findViewById(R.id.btnTesReguler);

        // Navigasi ke Jalur Pendaftaran
        if (btnJalurAkademik != null) {
            btnJalurAkademik.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, JalurAkademikActivity.class));
            });
        }

        if (btnTesBeasiswa != null) {
            btnTesBeasiswa.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, JalurTesBeasiswaActivity.class));
            });
        }

        if (btnJalurBeasiswa != null) {
            btnJalurBeasiswa.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, JalurBeasiswaActivity.class));
            });
        }

        if (btnTesReguler != null) {
            btnTesReguler.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, JalurTesRegulerActivity.class));
            });
        }

        // Navigasi ke Home
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(PendaftaranReguler.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            });
        }

        // Navigasi ke Profil
        if (navProfil != null) {
            navProfil.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, ProfilActivity.class));
            });
        }

        // Navigasi ke Fakultas
        if (navFakultas != null) {
            navFakultas.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, FakultasActivity.class));
            });
        }

        // Navigasi ke Fasilitas
        if (navFasilitas != null) {
            navFasilitas.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, FasilitasActivity.class));
            });
        }

        // Logika Klik Tombol Back
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                finish();
            });
        }

        // Fitur zoom popup pada gambar prosedur
        ImageView imgProsedur = findViewById(R.id.imgProsedur);
        if (imgProsedur != null) {
            ImagePopupHelper.makeZoomable(this, imgProsedur);
        }
    }
}
