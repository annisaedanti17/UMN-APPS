package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PendaftaranReguler extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_reguler);

        // Inisialisasi Tombol Jalur Pendaftaran
        ImageView btnJalurAkademik = findViewById(R.id.btnJalurAkademik);
        ImageView btnTesBeasiswa = findViewById(R.id.btnTesBeasiswa);
        ImageView btnprestasi = findViewById(R.id.btnprestasi);
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

        if (btnprestasi != null) {
            btnprestasi.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, JalurPrestasiActivity.class));
            });
        }

        if (btnTesReguler != null) {
            btnTesReguler.setOnClickListener(v -> {
                startActivity(new Intent(PendaftaranReguler.this, JalurTesRegulerActivity.class));
            });
        }

    }
}
