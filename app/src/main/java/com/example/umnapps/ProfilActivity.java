package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {

    // --- DATA SEJARAH (Looping) ---
    int[] daftarSejarah = {
            R.drawable.sejarah_1,
            R.drawable.sejarah_2,
            R.drawable.sejarah_3,
            R.drawable.sejarah_4,
            R.drawable.sejarah_5,
            R.drawable.sejarah_6
    };
    int indexSejarah = 0;

    // --- DATA LAMBANG (Looping) ---
    int[] daftarLambang = {
            R.drawable.lambang_umn,
            R.drawable.lambang_2,
            R.drawable.lambang_3,
            R.drawable.lambang_4
    };
    int indexLambang = 0;

    // --- DATA KEUNGGULAN (Looping) ---
    int[] daftarKeunggulan = {
            R.drawable.keunggulan_1,
            R.drawable.keunggulan_2
    };
    int indexKeunggulan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        // 1. Inisialisasi Komponen Slider
        final ImageView imgSejarah = findViewById(R.id.imgSejarah);
        ImageView btnNextSejarah = findViewById(R.id.btnNext);
        ImageView btnPrevSejarah = findViewById(R.id.btnPrev);

        final ImageView imgLambang = findViewById(R.id.imgLambang);
        ImageView btnNextLambang = findViewById(R.id.btnNextLambang);

        final ImageView imgKeunggulan = findViewById(R.id.imgKeunggulan);
        ImageView btnNextKeunggulan = findViewById(R.id.btnNextKeunggulan);

        // 2. Inisialisasi Bottom Navigation
        LinearLayout btnHome = findViewById(R.id.navHome);
        LinearLayout btnFakultas = findViewById(R.id.navFakultas);
        LinearLayout btnFasilitas = findViewById(R.id.navFasilitas);

        // --- LOGIKA SLIDER SEJARAH ---
        if (btnNextSejarah != null && imgSejarah != null) {
            btnNextSejarah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    indexSejarah = (indexSejarah + 1) % daftarSejarah.length;
                    imgSejarah.setImageResource(daftarSejarah[indexSejarah]);
                }
            });
        }

        if (btnPrevSejarah != null && imgSejarah != null) {
            btnPrevSejarah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    indexSejarah = (indexSejarah - 1 + daftarSejarah.length) % daftarSejarah.length;
                    imgSejarah.setImageResource(daftarSejarah[indexSejarah]);
                }
            });
        }

        // --- LOGIKA SLIDER LAMBANG ---
        if (btnNextLambang != null && imgLambang != null) {
            btnNextLambang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    indexLambang = (indexLambang + 1) % daftarLambang.length;
                    imgLambang.setImageResource(daftarLambang[indexLambang]);
                }
            });
        }

        // --- LOGIKA SLIDER KEUNGGULAN ---
        if (btnNextKeunggulan != null && imgKeunggulan != null) {
            btnNextKeunggulan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    indexKeunggulan = (indexKeunggulan + 1) % daftarKeunggulan.length;
                    imgKeunggulan.setImageResource(daftarKeunggulan[indexKeunggulan]);
                }
            });
        }

        // --- NAVIGASI BOTTOM NAV ---
        if (btnHome != null) {
            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfilActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            });
        }

        if (btnFakultas != null) {
            btnFakultas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfilActivity.this, FakultasActivity.class);
                    startActivity(intent);
                }
            });
        }

        // 4. Logika pindah ke Fasilitas
        if (btnFasilitas != null) {
            btnFasilitas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ProfilActivity.this, FasilitasActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}