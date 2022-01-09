package com.rahmanislam.quizpelajaranpokok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kuis_Bindo extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Opini penulis yang sesuai dengan isi tajuk rencana tersebut adalah …",
            "2. Pihak yang dituju dalam isi opini penulis pada tajuk rencana tersebut adalah ....",
            "3. Keberpihakan penulis (editorial) dalam kutipan tersebut adalah ....",
            "4. Dibawah ini yang merupakan pengertian dari informasi verbal adalah…….",
            "5. Kesulitan menulis  disebabkan oleh berbagai hal, antara lain ketepatan dalam penyusunan kalimat,ketepatan penggunaan ejaan,pemilihan kata,dan pengungkapan ide yang sesuai . Selain itu, dibutuhkan latihan rutin dalam memilih struktur yang efektif. Menulis merupakan hal yang sulit bagi masyarakat pada umumnya.\n" +
                    "\n" +
                    " Kesimpulan paragraf induktif tersebut adalah……"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            //jawaban soal nomor 1
            "a. Ternyata banyak tempat wisatawan yang perlu dibangun ditanah air ini dan harus dilestarikan keindahannya oleh masyarakat setempat dan dibantu oleh berbagai pihak.",
            "b. Tidak selalu dibebankan semuanya kepada pemerintah untuk membangun suatu daerah karena keterbatasan tenaga dan biaya yang tersedia, termasuk mempromosikan objek wisata.",
            "c. Kepedulian pemerintah sangat diharapkan untuk mempromosikan tempat wisata yang belum begitu banyak dikenal agar objek wisata dikenal dan wisatawan banyak berkunjung.",
            "d. Banyaknya tempat wisata yang indah dan menarik di tanah air seharusnya menjadi daya tarik wisatawan dalam negeri (lokal) daripada terdapat objek di luar negeri.",
            //jawaban soal nomor 2
            "a. masyarakat setempat", "b. pengelola wisata", " c. wisatawan mancanegara", "d. wisatawan lokal",
            //jawaban soal nomor 3
            "a. pemerintah pusat", "b. masyarakat setempat", "c. pengelola wisata", "d. wisatawan mancanegara",
            //jawaban soal nomor 4
            "A. Informasi yang biasanya ditampilkan dalam bentuk bagan, tabel, diagram, denah, dan matriks.",
            "B. Informasi yang didapat dari hasil observasi", "C. Informasi yang meliputi informasi lisan dan tulis",
            "D. Informasi yang berasal dari sebuah media berita",
            //jawaban soal nomor 5
            "A. Masyarakat pada umumnya malas menulis", "B. Menulis merupakan hal yang sulit bagi masyarakat umum²", "C. Masyarakat pandai menulis", "D. Memilih struktur yang efektif"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "c. Kepedulian pemerintah sangat diharapkan untuk mempromosikan tempat wisata yang belum begitu banyak dikenal agar objek wisata dikenal dan wisatawan banyak berkunjung.",
            "a. masyarakat setempat",
            "b. masyarakat setempat",
            "C. Informasi yang meliputi informasi lisan dan tulis",
            "B. Menulis merupakan hal yang sulit bagi masyarakat umum²"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_bindo);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Kamu Jawab Dulu",Toast.LENGTH_LONG).show();
        }
    }
}