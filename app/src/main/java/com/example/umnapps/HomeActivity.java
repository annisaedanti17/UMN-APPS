package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inisialisasi Tombol Navigasi Bawah
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);
        ImageView btnKlikPendaftaran = findViewById(R.id.btnKlikPendaftaran);

        // Inisialisasi Tombol Fakultas di Home
        LinearLayout btnFakultasTeknik = findViewById(R.id.btnFakultasTeknik);
        LinearLayout btnFakultasBisnis = findViewById(R.id.btnFakultasBisnis);
        LinearLayout btnFakultasKomunikasi = findViewById(R.id.btnFakultasKomunikasi);
        LinearLayout btnFakultasSeniDesain = findViewById(R.id.btnFakultasSeniDesain);
        TextView btnViewAllFakultas = findViewById(R.id.btnViewAllFakultas);

        // Inisialisasi View All Berita
        TextView btnViewAllBerita = findViewById(R.id.btnViewAllBerita);

        // Inisialisasi Kartu Berita
        ImageView berita1 = findViewById(R.id.berita1);
        ImageView berita2 = findViewById(R.id.berita2);
        ImageView berita3 = findViewById(R.id.berita3);

        // Navigasi ke BeritaActivity
        if (btnViewAllBerita != null) {
            btnViewAllBerita.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, BeritaActivity.class);
                startActivity(intent);
            });
        }

        // Navigasi ke Pendaftaran
        if (btnKlikPendaftaran != null) {
            btnKlikPendaftaran.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, PendaftaranActivity.class);
                startActivity(intent);
            });
        }

        // Navigasi ke Profil
        if (navProfil != null) {
            navProfil.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, ProfilActivity.class);
                startActivity(intent);
            });
        }

        // Navigasi ke Fakultas
        if (navFakultas != null) {
            navFakultas.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, FakultasActivity.class);
                startActivity(intent);
            });
        }

        // Navigasi ke Fasilitas
        if (navFasilitas != null) {
            navFasilitas.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, FasilitasActivity.class);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK ICON FAKULTAS ---
        if (btnFakultasTeknik != null) {
            btnFakultasTeknik.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, FakultasTeknik.class));
            });
        }

        if (btnFakultasBisnis != null) {
            btnFakultasBisnis.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, FakultasBisnis.class));
            });
        }

        if (btnFakultasKomunikasi != null) {
            btnFakultasKomunikasi.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, FakultasIlkom.class));
            });
        }

        if (btnFakultasSeniDesain != null) {
            btnFakultasSeniDesain.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, FakultasSeniDesain.class));
            });
        }

        // "View All" Fakultas → ke halaman daftar semua fakultas
        if (btnViewAllFakultas != null) {
            btnViewAllFakultas.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, FakultasActivity.class));
            });
        }

        // --- LOGIKA KLIK BERITA 1 ---
        if (berita1 != null) {
            berita1.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, DetailBeritaActivity.class);
                intent.putExtra("KUNCI_JUDUL", "Manfaat Solar Panel: Solusi Cerdas untuk Efisiensi Energi Masa Kini");

                intent.putExtra("KUNCI_ISI",
                        "Solar panel atau dikenal juga sebagai panel surya merupakan sebuah alat yang mengubah energi cahaya matahari menjadi energi listrik melalui proses fotovoltaik. Dulu solar panel sering dimanfaatkan sebagai alternatif untuk industri agar mengurangi jejak emisi karbon, namun beberapa tahun belakangan ini solar panel banyak dicari dan dibutuhkan untuk menjadi sumber energi terbarukan di tengah perubahan iklim dan ketersediaan sumber daya alam yang semakin terbatas. Dengan demikian masyarakat perlu memiliki pengetahuan terkait manfaat solar panel yang digunakan untuk efisiensi energi masa kini.<br><br>" +
                                "<b>Penghematan Biaya Listrik</b><br>" +
                                "Saat ini telah banyak gedung besar maupun atap rumah yang menggunakan solar panel dengan tujuan untuk penghematan biaya listrik. Sebagai contoh pada gedung Universitas Multimedia Nusantara (UMN) telah menggunakan lebih dari 300 buah solar panel yang dipasang di atas gedung B sehingga bisa menghemat total biaya penggunaan listriknya hingga 15%. Hal ini juga menjadikan UMN menyandang peringkat 146 dari 1183 universitas seluruh dunia di UI GreenMetric World University Rankings 2023.<br><br>" +
                                "<b>Ramah Lingkungan</b><br>" +
                                "Pemilihan solar panel sebagai pengganti listrik adalah salah satu langkah yang tepat untuk proses yang ramah lingkungan dengan mengurangi polusi atau emisi gas rumah kaca. Hal ini dikarenakan solar panel tidak menimbulkan hal tersebut sehingga bisa menjaga kualitas udara dan mengurangi dampak perubahan iklim sehingga cocok untuk keberlanjutan energi di masa depan.<br><br>" +
                                "<b>Kemandirian Energi</b><br>" +
                                "Penggunaan solar panel sebagai renewable energy atau energi terbarukan bisa menjadi alternatif untuk proses kemandirian energi dikarenakan menggunakan sumber daya alam yang selalu ada, yaitu energi cahaya matahari. Dengan menggunakan sistem solar panel, rumah atau bangunan dapat memproduksi listrik sendiri dan bisa menyimpannya dengan baterai, sehingga tidak ketergantungan pada energi fosil. Selain itu jika suatu saat terjadi mati listrik, bisa menggunakan pasokan tenaga listrik dari yang dihasilkan oleh solar panel.<br><br>" +
                                "<b>Perawatan Mudah dan Efisiensi Operasional</b><br>" +
                                "Pemasangan solar panel pada suatu bangunan memiliki umur yang panjang (sekitar 25-30 tahun). Biaya pemasangan dan perawatan dalam sistem solar panel masih sebanding bahkan lebih menguntungkan dengan banyaknya manfaat yang didapatkan. Pemasangan solar panel pun dikerjakan oleh teknisi yang ahli di bidangnya serta membutuhkan kunjungan pemeliharaan tahunan untuk melakukan tes pada inverter dan arus listrik yang mengalir. Bahkan kini hampir semua sistem solar panel hadir with platform pemantauan online gratis yang bisa digunakan untuk melacak kinerja dan efisiensi sistem panel surya."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita1);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK BERITA 2 ---
        if (berita2 != null) {
            berita2.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, DetailBeritaActivity.class);
                intent.putExtra("KUNCI_JUDUL", "UMN Jadi Kampus Ramah Lingkungan dengan Pemanfaatan Solar Panel");

                intent.putExtra("KUNCI_ISI",
                        "Universitas Multimedia Nusantara dikenal bukan hanya sebagai kampus teknologi dan komunikasi yang ada di Indonesia, tetapi juga sebagai pelopor kampus ramah lingkungan (green campus). Salah satu langkah nyata UMN dalam mendukung keberlanjutan energi adalah pemanfaatan panel surya (solar panel) sebagai sumber energi alternatif di lingkungan kampus.<br>" +
                                "Komitmen UMN terhadap energi terbarukan ini menjadi langkah dalam membantu mengurangi jejak karbon. Program penggunaan solar panel bisa dilihat langsung dengan adanya pemasangan sistem solar panel di atas gedung B kampus, yang berfungsi untuk menghasilkan listrik dari sinar matahari.<br>" +
                                "Energi yang dihasilkan dari panel surya ini membantu menekan penggunaan listrik dari sumber konvensional dan menjadi langkah nyata UMN dalam mendukung transisi menuju energi bersih.<br><br>" +

                                "<b>Manfaat Solar Panel di UMN</b><br>" +
                                "&#8226; Efisiensi Energi<br>" +
                                "Mengurangi ketergantungan pada listrik dari sumber konvensional dan mengurangi penggunaan biaya operasional kampus.<br>" +
                                "&#8226; Ramah Lingkungan<br>" +
                                "Menurunkan emisi karbon dan mendukung target pembangunan berkelanjutan (SDGs).<br>" +
                                "&#8226; Edukasi dan Riset<br>" +
                                "Menjadi sarana pembelajaran nyata bagi mahasiswa dalam bidang energi terbarukan, teknik elektro, dan lingkungan.<br>" +
                                "&#8226; Inovasi Kampus Hijau<br>" +
                                "Mendorong kesadaran sivitas akademika terhadap pentingnya konservasi energi.<br><br>" +

                                "<b>Kemandirian Energi</b><br>" +
                                "Penggunaan solar panel sebagai renewable energy atau energi terbarukan bisa menjadi alternatif untuk proses kemandirian energi dikarenakan menggunakan sumber daya alam yang selalu ada, yaitu energi cahaya matahari. Dengan menggunakan sistem solar panel, rumah atau bangunan dapat memproduksi listrik sendiri dan bisa menyimpannya dengan baterai, sehingga tidak ketergantungan pada energi fosil. Selain itu jika suatu saat terjadi mati listrik, bisa menggunakan pasokan tenaga listrik dari yang dihasilkan oleh solar panel.<br><br>" +

                                "<b>Perawatan Mudah dan Efisiensi Operasional</b><br>" +
                                "Pemasangan solar panel pada suatu bangunan memiliki umur yang panjang (sekitar 25-30 tahun). Biaya pemasangan dan perawatan dalam sistem solar panel masih sebanding bahkan lebih menguntungkan dengan banyaknya manfaat yang didapatkan. Pemasangan solar panel pun dikerjakan oleh teknisi yang ahli di bidangnya serta membutuhkan kunjungan pemeliharaan tahunan untuk melakukan tes pada inverter dan arus listrik yang mengalir. Bahkan kini hampir semua sistem solar panel hadir with platform pemantauan online gratis yang bisa digunakan untuk melacak kinerja dan efisiensi sistem panel surya."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita2);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK BERITA 3 ---
        if (berita3 != null) {
            berita3.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, DetailBeritaActivity.class);
                intent.putExtra("KUNCI_JUDUL", "Gimana UMN Menerapkan Energi Terbarukan?");

                intent.putExtra("KUNCI_ISI",
                        "Mungkin, banyak dari kalian yang masih belum tahu kalau Universitas Multimedia Nusantara (UMN) merupakan salah satu kampus yang turut menerapkan konsep energi terbarukan dalam fasilitasnya.<br><br>" +
                                "Langkah tersebut merupakan bagian dari upaya UMN untuk mendukung penerapan prinsip keberlanjutan dan turut serta menjaga lingkungan. Penerapan konsep energi terbarukan ini juga menjadi cara UMN untuk menjadi contoh positif dalam dunia pendidikan di Indonesia dan dunia.<br><br>" +
                                "<b>Penerapan Panel Surya</b><br>" +
                                "UMN sendiri menerapkan energi terbarukan panel surya. Sebanyak 372 panel surya terpasang untuk menjadi pemasok listrik di Gedung B Kampus UMN. Pemasangan panel surya tersebut merupakan upaya UMN untuk mengurangi penggunaan bahan bakar fosil yang kita ketahui membawa dampak negatif untuk kualitas udara di dunia.<br><br>" +
                                "<b>Penggunaan Lampu LED Hemat Energi</b><br>" +
                                "Tak hanya panel surya, UMN juga telah mengganti lampu tradisional yang digunakan dengan lampu LED hemat energi di seluruh kampus. Harapannya, penggunaan hemat energi tersebut bisa mengurangi pemakaian listrik dan bertahan lebih lama.<br>" +
                                "UMN juga memasang lampu dengan sensor inframerah di ruang publiknya, termasuk di toilet, yang bertujuan untuk memastikan lampu tersebut hanya menyala jika ada orang di sekitarnya.<br><br>" +
                                "<b>Double Skin Facade</b><br>" +
                                "Selain itu, UMN turut menerapkan konsep double skin facade di gedung perkuliahannya. Penerapan konsep tersebut dilakukan untuk mengontrol intensitas cahaya dan panas matahari yang masuk ke ruang perkuliahan.<br><br>" +
                                "<b>Instalasi Pengolahan Limbah (IPAL) Internal</b><br>" +
                                "Tak hanya itu, UMN juga telah menerapkan sistem pengolahan air limbah yang canggih untuk mendaur ulang air secara efisien di seluruh kampus. Air limbah yang berasal dari toilet, urinal, wastafel, and dapur diolah menggunakan Sewage Treatment Plant (STP). Hasil air daur ulang itu lalu digunakan kembali untuk irigasi dan pembilasan toilet.<br><br>" +
                                "Lewat berbagai upaya tersebut, Universitas Multimedia Nusantara berhasil mendapatkan peringkat 128 dalam nominasi universitas paling berkelanjutan di dunia berdasarkan UI GreenMetric pada 2024. UMN juga mendapatkan peringkat 1 dalam kategori kampus swasta paling berkelanjutan se Jabodetabek.<br><br>" +
                                "Pengen tau lebih lanjut soal fakta menarik UMN lainnya? Jangan lupa tunggu informasi terbarunya di website umn.ac.id!"
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita3);
                startActivity(intent);
            });
        }

    }
}