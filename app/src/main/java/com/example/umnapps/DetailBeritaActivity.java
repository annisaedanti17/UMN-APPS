package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailBeritaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        // 1. Inisialisasi Konten Berita
        ImageView imgDetail = findViewById(R.id.imgDetailBerita);
        TextView tvJudul = findViewById(R.id.tvDetailJudul);
        TextView tvIsi = findViewById(R.id.tvDetailIsi);


        // 2. Inisialisasi Navigasi Bawah
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);

        // Inisialisasi Tombol Back
        ImageView btnBack = findViewById(R.id.btnBack);

        // 3. TANGKAP PAKET DARI BERITAACTIVITY
        String judulDiterima = getIntent().getStringExtra("KUNCI_JUDUL");
        String isiDiterima = getIntent().getStringExtra("KUNCI_ISI");
        int gambarDiterima = getIntent().getIntExtra("KUNCI_GAMBAR", 0);

        // 4. PASANG DATA KE TAMPILAN
        if (judulDiterima != null) {
            tvJudul.setText(judulDiterima);
        }
        if (isiDiterima != null) {
            // Kita pakai Html.fromHtml supaya tag <b> (bold) dari string bisa terbaca!
            tvIsi.setText(Html.fromHtml(isiDiterima, Html.FROM_HTML_MODE_LEGACY));
        }
        if (gambarDiterima != 0) {
            imgDetail.setImageResource(gambarDiterima);
        }

        // 5. LOGIKA KLIK NAVBAR
        if (navHome != null) navHome.setOnClickListener(v -> { startActivity(new Intent(this, HomeActivity.class)); finish(); });
        if (navProfil != null) navProfil.setOnClickListener(v -> { startActivity(new Intent(this, ProfilActivity.class)); finish(); });
        if (navFakultas != null) navFakultas.setOnClickListener(v -> { startActivity(new Intent(this, FakultasActivity.class)); finish(); });
        if (navFasilitas != null) navFasilitas.setOnClickListener(v -> { startActivity(new Intent(this, FasilitasActivity.class)); finish(); });



        // Logika Klik Tombol Back
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                finish(); // Ini akan menutup halaman dan kembali ke halaman sebelumnya
            });
        }
    }
}