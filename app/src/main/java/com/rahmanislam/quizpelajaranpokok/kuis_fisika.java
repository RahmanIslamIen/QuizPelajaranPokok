package com.rahmanislam.quizpelajaranpokok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kuis_fisika extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Pekerjaan berikut dapat dilakukan di laboratorium:",
            "2. Jumlah berikut termasuk jumlah nominal adalah …",
            "3. Kelompok-kelompok berikut secara eksklusif terdiri dari jumlah turunan, kecuali …",
            "4. Saat mengukur panjang objek, hasil pengukuran adalah 0,04070 meter. Hasil pengukuran mengandung sejumlah … nomor penting.",
            "5. Hasil pengukuran luas pelat tipis dengan panjang 1,25 cm dan lebar 0,15 cm sesuai aturan tokoh penting"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "A. Bawa makanan", "B. Bermain-main", "C. Bawalah minuman", "D. Dengan jas lab",
            "A. Pencahayaan yang panjang, kuat, suhu", "B. massa, jumlah zat, arus listrik yang kuat", " C. Berat, suhu, waktu", "D. Panjang, energi, waktu",
            "A. Lebar, gaya, energi", "B. Jenis, energi, usaha", "C. Usaha, arus kuat, akselerasi", "D. Volume, kepadatan, kecepatan",
            "A. Dua", "B. Tiga", "C. Empat", "D. Lima",
            "A. 0,1875 cm²", "B. 0,188 cm²", "C. 0,187 cm²", "D. 0,19 cm²"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "D. Dengan jas lab",
            "B. massa, jumlah zat, arus listrik yang kuat",
            "C. Usaha, arus kuat, akselerasi",
            "C. Empat",
            "C. 0,187 cm²"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_fisika);

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