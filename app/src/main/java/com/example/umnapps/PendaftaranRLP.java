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

        // Inisialisasi Tombol Back
        ImageView btnBack = findViewById(R.id.btnBack);
        ImageView btnRplS1 = findViewById(R.id.  btnRplS1);
        ImageView btnRplS2 = findViewById(R.id.  btnRplS2);


        // Logika Klik Tombol Back
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                finish(); // Ini akan menutup halaman dan kembali ke halaman sebelumnya
            });
        }

        if (btnRplS1 != null) {
            btnRplS1.setOnClickListener(v -> {
                Intent intent = new Intent(PendaftaranRLP.this, JalurRPL1.class);
                startActivity(intent);
            });
        }

        if (btnRplS2 != null) {
            btnRplS2.setOnClickListener(v -> {
                Intent intent = new Intent(PendaftaranRLP.this, JalurRPL2.class);
                startActivity(intent);
            });
        }
    }
}
