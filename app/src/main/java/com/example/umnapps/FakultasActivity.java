package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FakultasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakultas);

        // 1. Inisialisasi Navbar Bawah
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);
        // navFakultas tidak perlu diberi fungsi klik karena kita sedang di halaman ini

        // 2. Inisialisasi Kartu Fakultas
        ImageView btnFakultasTeknik = findViewById(R.id.btnFakultasTeknik);
        ImageView btnFakultasBisnis = findViewById(R.id.btnFakultasBisnis);
        ImageView btnFakultasIlkom = findViewById(R.id.btnFakultasIlmuKomunikasi);
        ImageView btnFakultasSeniBudaya = findViewById(R.id.btnFakultasSeniBudaya);

        // --- LOGIKA KLIK NAVBAR BAWAH ---
        if (navHome != null) navHome.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
            finish(); // Tutup agar tidak menumpuk di memori
        });

        if (navProfil != null) navProfil.setOnClickListener(v -> {
            startActivity(new Intent(this, ProfilActivity.class));
            finish();
        });

        if (navFasilitas != null) navFasilitas.setOnClickListener(v -> {
            startActivity(new Intent(this, FasilitasActivity.class));
            finish();
        });

        // --- LOGIKA KLIK KARTU FAKULTAS (Untuk masuk ke halamannya) ---
        if (btnFakultasTeknik != null) {
            btnFakultasTeknik.setOnClickListener(v -> {
                // Nanti buat Activity baru bernama FakultasTeknikActivity
                Intent intent = new Intent(FakultasActivity.this, FakultasTeknik.class);
                startActivity(intent);
            });
        }

        if (btnFakultasBisnis != null) {
            btnFakultasBisnis.setOnClickListener(v -> {
                // Nanti buat Activity baru bernama FakultasBisnisActivity
                Intent intent = new Intent(FakultasActivity.this, FakultasBisnis.class);
                startActivity(intent);
            });
        }

        if (btnFakultasIlkom != null) {
            btnFakultasIlkom.setOnClickListener(v -> {
                Intent intent = new Intent(FakultasActivity.this, FakultasIlkom.class);
                startActivity(intent);
            });
        }

        if (btnFakultasSeniBudaya != null) {
            btnFakultasSeniBudaya.setOnClickListener(v -> {
                Intent intent = new Intent(FakultasActivity.this, FakultasSeniDesain.class);
                startActivity(intent);
            });
        }
    }
}