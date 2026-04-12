package com.example.umnapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class BeritaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        // 1. Inisialisasi Navigasi Bawah
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navProfil = findViewById(R.id.navProfil);
        LinearLayout navFakultas = findViewById(R.id.navFakultas);
        LinearLayout navFasilitas = findViewById(R.id.navFasilitas);

        // Inisialisasi Tombol Back
        ImageView btnBack = findViewById(R.id.btnBack);

        // 2. Inisialisasi Kartu Berita
        ImageView berita1 = findViewById(R.id.berita1);
        ImageView berita2 = findViewById(R.id.berita2);
        ImageView berita3 = findViewById(R.id.berita3);
        ImageView berita4 = findViewById(R.id.berita4);
        ImageView berita5 = findViewById(R.id.berita5);
        ImageView berita6 = findViewById(R.id.berita6);

        // --- LOGIKA KLIK NAVBAR ---
        if (navHome != null) navHome.setOnClickListener(v -> { startActivity(new Intent(this, HomeActivity.class)); finish(); });
        if (navProfil != null) navProfil.setOnClickListener(v -> { startActivity(new Intent(this, ProfilActivity.class)); finish(); });
        if (navFakultas != null) navFakultas.setOnClickListener(v -> { startActivity(new Intent(this, FakultasActivity.class)); finish(); });
        if (navFasilitas != null) navFasilitas.setOnClickListener(v -> { startActivity(new Intent(this, FasilitasActivity.class)); finish(); });

        // --- LOGIKA KLIK BERITA 1 ---
        if (berita1 != null) {
            berita1.setOnClickListener(v -> {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
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
                                "Pemasangan solar panel pada suatu bangunan memiliki umur yang panjang (sekitar 25-30 tahun). Biaya pemasangan dan perawatan dalam sistem solar panel masih sebanding bahkan lebih menguntungkan dengan banyaknya manfaat yang didapatkan. Pemasangan solar panel pun dikerjakan oleh teknisi yang ahli di bidangnya serta membutuhkan kunjungan pemeliharaan tahunan untuk melakukan tes pada inverter dan arus listrik yang mengalir. Bahkan kini hampir semua sistem solar panel hadir dengan platform pemantauan online gratis yang bisa digunakan untuk melacak kinerja dan efisiensi sistem panel surya."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita1);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK BERITA 2 ---
        if (berita2 != null) {
            berita2.setOnClickListener(v -> {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
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
                                "Pemasangan solar panel pada suatu bangunan memiliki umur yang panjang (sekitar 25-30 tahun). Biaya pemasangan dan perawatan dalam sistem solar panel masih sebanding bahkan lebih menguntungkan dengan banyaknya manfaat yang didapatkan. Pemasangan solar panel pun dikerjakan oleh teknisi yang ahli di bidangnya serta membutuhkan kunjungan pemeliharaan tahunan untuk melakukan tes pada inverter dan arus listrik yang mengalir. Bahkan kini hampir semua sistem solar panel hadir dengan platform pemantauan online gratis yang bisa digunakan untuk melacak kinerja dan efisiensi sistem panel surya."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita2);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK BERITA 3 ---
        if (berita3 != null) {
            berita3.setOnClickListener(v -> {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
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

        // --- LOGIKA KLIK BERITA 4 ---
        if (berita4 != null) {
            berita4.setOnClickListener(v -> {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
                intent.putExtra("KUNCI_JUDUL", "Bagaimana AI Mengubah Wajah Energi Bersih di Era Modern");

                intent.putExtra("KUNCI_ISI",
                        "Mungkin, banyak dari kalian yang masih belum tahu kalau Universitas Multimedia Nusantara (UMN) merupakan salah satu kampus yang turut menerapkan konsep energi terbarukan dalam fasilitasnya.<br><br>" +
                                "Di tengah meningkatnya kebutuhan energi dan ancaman perubahan iklim, kecerdasan buatan (AI) hadir sebagai teknologi kunci yang mampu mempercepat transisi menuju energi bersih dan efisien. Energi bersih adalah energi yang berasal dari sumber terbarukan, tanpa emisi serta tidak mencemari atmosfer saat digunakan.<br><br>" +
                                "Saat ini sebagian besar dari kita masih menggunakan energi yang berasal dari bahan bakar fosil seperti minyak bumi, batu bara dan gas alam. Ketergantungan ini menimbulkan berbagai tantangan serius, mulai dari menipisnya sumber daya alam, kenaikan harga energi, hingga peningkatan emisi karbon yang memperburuk perubahan iklim.<br><br>" +
                                "<b>Pentingnya Energi Bersih</b><br>" +
                                "Energi bersih perlu untuk diterapkan agar bisa mengurangi emisi gas rumah kaca serta polusi udara yang berkontribusi terhadap perubahan iklim dan masalah kesehatan. Beberapa contoh energi bersih antara lain energi matahari yang mengkonversi sinar matahari menjadi listrik, energi angin yang mengubah energi kinetik angin menjadi energi listrik, energi air atau hidro energi, serta energi biomassa.<br><br>" +
                                "<b>Dampak Positif AI terhadap Lingkungan</b><br>" +
                                "Teknologi AI memiliki peranan penting dalam pengembangan energi bersih serta berdampak besar terhadap efisiensi, keberlanjutan serta pengelolaan sumber daya energi. Beberapa peranannya antara lain mampu memprediksi dan manajemen produksi energi terbarukan, optimalisasi jaringan listrik (smart grid), pemeliharaan prediktif, analisis data untuk efisiensi energi, serta memberikan dukungan terhadap transisi energi."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita4);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK BERITA 5 ---
        if (berita5 != null) {
            berita5.setOnClickListener(v -> {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
                intent.putExtra("KUNCI_JUDUL", "Inovasi Energi Bersih di Dunia Pendidikan: UMN Jadi Pelopor");

                intent.putExtra("KUNCI_ISI",
                        "Isu keberlanjutan dan krisis energi global kini menjadi perhatian utama berbagai sektor, termasuk dunia pendidikan. Sebagai institusi yang memiliki peran penting dalam mencetak generasi masa depan, perguruan tinggi memiliki tanggung jawab besar dalam menerapkan dan mengedukasi penggunaan energi bersih dan ramah lingkungan.<br><br>" +
                                "Penerapan inovasi energi bersih dapat ditemukan di Universitas Multimedia Nusantara (UMN), kampus yang dikenal dengan komitmennya terhadap inovasi teknologi dan keberlanjutan lingkungan. Melalui berbagai program, riset, dan implementasi teknologi hijau, kampus UMN turut berperan aktif dalam mendukung transisi menuju energi terbarukan.<br><br>" +
                                "<b>Inovasi Energi Bersih di Dunia Pendidikan</b><br>" +
                                "Berikut adalah contoh inovasi energi bersih yang telah diterapkan di dunia pendidikan:<br><br>" +
                                "<b>1. Pemanfaatan Energi Surya (Solar Panel)</b><br>" +
                                "Salah satu langkah paling nyata dalam penerapan energi bersih di dunia pendidikan adalah penggunaan panel surya untuk mendukung kebutuhan listrik kampus. Panel surya UMN dipasang di area gedung sebagai sumber energi alternatif yang ramah lingkungan.<br><br>" +
                                "<b>2. Penerapan Konsep Green Building dan Efisiensi Energi</b><br>" +
                                "Kampus modern kini mengadopsi konsep bangunan hijau (green building) yang efisien energi. Desain arsitektur dibuat agar memaksimalkan pencahayaan alami dan ventilasi udara, mengurangi kebutuhan pendingin buatan, dan menggunakan material ramah lingkungan.<br><br>" +
                                "<b>3. Program Edukasi dan Riset Energi Terbarukan</b><br>" +
                                "Selain implementasi teknologi, UMN juga menanamkan nilai keberlanjutan melalui kurikulum dan kegiatan riset. Mahasiswa dari program studi Teknik Fisika dan Teknik Elektro yang didorong untuk melakukan penelitian tentang teknologi energi surya.<br><br>" +
                                "<b>4. Pengelolaan Limbah dan Daur Ulang Energi</b><br>" +
                                "Di UMN telah mengimplementasikan program pemilahan sampah, pengomposan organik menjadi Eco-Enzim, dan pengolahan limbah air untuk digunakan kembali untuk keperluan yang tidak bersentuhan langsung dengan sivitas akademika."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita5);
                startActivity(intent);
            });
        }

        // --- LOGIKA KLIK BERITA 6 ---
        if (berita6 != null) {
            berita6.setOnClickListener(v -> {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
                intent.putExtra("KUNCI_JUDUL", "Green Innovation: Langkah Nyata Menuju Masa Depan Berkelanjutan");

                intent.putExtra("KUNCI_ISI",
                        "Saat ini mayoritas kegiatan di dunia masih memiliki ketergantungan terhadap energi fosil yang mana memberikan berbagai dampak terhadap lingkungan, terutama emisi karbon yang dihasilkan sehingga menyebabkan krisis iklim global. Hal ini bisa disikapi dengan langkah nyata yaitu green innovation atau inovasi hijau untuk menciptakan solusi yang efisien dan ramah lingkungan.<br><br>" +
                                "Green innovation hadir sebagai penggunaan teknologi produksi baru yang mengurangi risiko lingkungan serta pemanfaatan sumber daya alam yang efektif dan berkelanjutan. Green innovation ini sudah mulai diterapkan contohnya seperti pemasangan solar panel pada gedung atau atap rumah. Berikut contoh green innovation yang bisa diterapkan:<br><br>" +
                                "<b>Energi Terbarukan</b><br>" +
                                "Energi terbarukan atau renewable energy adalah energi yang berasal dari sumber daya alam yang dapat diperbarui yaitu seperti energi matahari, air, angin, panas bumi, dan biomassa. Beberapa contoh penerapan energi terbarukan antara lain pemasangan solar panel, turbin angin, dan biogas.<br><br>" +
                                "<b>Transportasi Ramah Lingkungan</b><br>" +
                                "Saat ini banyak kota yang telah menggunakan transportasi ramah lingkungan demi mengurangi dampak negatif terhadap lingkungan. Contoh nyata adalah banyaknya transportasi umum seperti bus listrik, kereta api, dan motor atau mobil listrik.<br><br>" +
                                "<b>Green Building</b><br>" +
                                "Green building atau bangunan hijau merupakan suatu konsep bangunan yang dirancang untuk menjadi bangunan yang efisien dan ramah lingkungan. Green building ini juga telah diterapkan pada salah satu kampus di Indonesia yaitu UMN yang menggunakan panel surya sebagai sumber listrik dan memiliki infrastruktur ruang terbuka hijau (RTH) yang luas.<br><br>" +
                                "Sebagai bentuk kepedulian terhadap lingkungan, UMN juga memiliki sistem pengelolaan air yang baik dengan konsep daur ulang air. Kunjungi www.umn.ac.id untuk info lebih lanjut."
                );
                intent.putExtra("KUNCI_GAMBAR", R.drawable.berita6);
                startActivity(intent);
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