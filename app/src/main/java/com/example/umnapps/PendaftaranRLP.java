package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PendaftaranRLP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_rlp);

        // Inisialisasi Tombol Navigasi Bawah
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);
        // Inisialisasi Tombol Back
        ImageView btnBack = findViewById(R.id.btnBack);



        // Navigasi ke Home
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranRLP.this, HomeActivity.class));
            });
        }

        // Navigasi ke Profil
        if (navProfil != null) {
            navProfil.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranRLP.this, ProfilActivity.class));
            });
        }

        // Navigasi ke Fakultas
        if (navFakultas != null) {
            navFakultas.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranRLP.this, FakultasActivity.class));
            });
        }

        // Navigasi ke Fasilitas
        if (navFasilitas != null) {
            navFasilitas.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranRLP.this, FasilitasActivity.class));
            });
        }

        // Logika Klik Tombol Back
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                finish(); // Ini akan menutup halaman dan kembali ke halaman sebelumnya
            });
        }
    }
}
