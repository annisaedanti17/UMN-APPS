package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FasilitasActivity extends AppCompatActivity {

    // Data Fasilitas
    String[] namaFasilitas = {"Fasilitas Umum", "Fasilitas Fakultas Teknik", "Fasilitas Fakultas Bisnis", "Fasilitas Fakultas Komunikasi", "Fasilitas Fakultas Seni & Desain"};
    int[] gambarFasilitas = {
            R.drawable.fasilitas_umum,
            R.drawable.fasilitas_fteknik,
            R.drawable.fasilitas_fbisnis,
            R.drawable.fasilitas_ilmukomunikasi,
            R.drawable.fasilitas_fsenidesain
    };
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas);

        // Inisialisasi UI
        TextView txtNama = findViewById(R.id.txtNamaFasilitas);
        ImageView imgFasilitas = findViewById(R.id.imgFasilitas);
        ImageView btnPrev = findViewById(R.id.btnPrevFasilitas);
        ImageView btnNext = findViewById(R.id.btnNextFasilitas);

        // Inisialisasi Navigasi Bawah
        LinearLayout btnProfil = findViewById(R.id.navProfil);
        LinearLayout btnFakultas = findViewById(R.id.navFakultas);
        LinearLayout btnHome = findViewById(R.id.navHome);

        // Logika Tombol Next
        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % namaFasilitas.length;
            txtNama.setText(namaFasilitas[currentIndex]);
            imgFasilitas.setImageResource(gambarFasilitas[currentIndex]);
        });

        // Logika Tombol Prev
        btnPrev.setOnClickListener(v -> {
            currentIndex = (currentIndex - 1 + namaFasilitas.length) % namaFasilitas.length;
            txtNama.setText(namaFasilitas[currentIndex]);
            imgFasilitas.setImageResource(gambarFasilitas[currentIndex]);
        });

        // Navigasi Bottom Bar
        if (btnHome != null) btnHome.setOnClickListener(v -> startActivity(new Intent(this, HomeActivity.class)));
        if (btnProfil != null) btnProfil.setOnClickListener(v -> startActivity(new Intent(this, ProfilActivity.class)));
        if (btnFakultas != null) btnFakultas.setOnClickListener(v -> startActivity(new Intent(this, FakultasActivity.class)));
    }
}