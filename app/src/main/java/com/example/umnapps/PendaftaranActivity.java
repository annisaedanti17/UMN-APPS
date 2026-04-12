package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PendaftaranActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        // Inisialisasi Tombol Navigasi Bawah
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);

        // Inisialisasi Tombol Jalur Pendaftaran
        ImageView btnReguler = findViewById(R.id.btnreguler);
        ImageView btnIntern = findViewById(R.id.btnIntern);
        ImageView btnRLP = findViewById(R.id.btnRLP);
        // Inisialisasi Tombol Back
        ImageView btnBack = findViewById(R.id.btnBack);

        // Navigasi ke Jalur Reguler
        if (btnReguler != null) {
            btnReguler.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, PendaftaranReguler.class));
            });
        }

        // Navigasi ke Jalur Internasional
        if (btnIntern != null) {
            btnIntern.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, PendaftaranInternasional.class));
            });
        }

        // Navigasi ke Jalur RLP
        if (btnRLP != null) {
            btnRLP.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, PendaftaranRLP.class));
            });
        }

        // Navigasi ke Home
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, HomeActivity.class));
            });
        }
        
        // Navigasi ke Profil
        if (navProfil != null) {
            navProfil.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, ProfilActivity.class));
            });
        }

        // Navigasi ke Fakultas
        if (navFakultas != null) {
            navFakultas.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, FakultasActivity.class));
            });
        }

        // Navigasi ke Fasilitas
        if (navFasilitas != null) {
            navFasilitas.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, FasilitasActivity.class));
            });
        }

        // Logika Klik Tombol Back
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranActivity.this, HomeActivity.class));
            });
        }
    }
}
