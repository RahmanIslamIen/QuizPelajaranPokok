package com.rahmanislam.quizpelajaranpokok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kuis_mtk extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Jika x dan y adalah solusi dari sistem persamaan 4x + y = 9 dan x + 4y = 6, maka nilai 2x + 3y.",
            "2. Persamaan garis vertikal dengan 2x – 3y + 8 = 0 dan melalui titik (-3.2) adalah.",
            "3. Peluru ditembakkan ke atas pada kecepatan awal vo m / detik. Ketinggian lantai setelah t detik dinyatakan oleh fungsi h (t) = 100 + 40t – 4t2. Tinggi maksimum yang bisa dicapai bola adalah.",
            "4. Kemampuan petani untuk mengolah sampah menjadi kompos dari hari ke hari semakin baik. Pada hari pertama ia mampu mengolah 2 m3 sampah, pada hari kedua 5 m3 sampah dan pada hari ketiga 8 m3 sampah. Pada hari ke 10, petani dapat memproses limbah berikut.",
            "5. Persamaan garis lurus melalui titik (8, 0) dan (0, 6) adalah."
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "A.6", "B.7", "C.8", "D.9",
            "A. -2x + 3y-12 = 0", "B. 3x + 2y + 5 = 0", " C. 3x + 2y-13 = 0", "D. 3x + 2y = 0",
            "A. 50 m", "B. 300 m", "C. 200 m", "D. 100 m",
            "A. 29 m3", "B. 56 m3", "C. 100 m3", "D. 155 m3",
            "A. 8x + 6 y = 48", "B. 6x -8y = 483", "C. 8x + 6th> 48", "D. 6x + 8tahun <48"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "D.9",
            "D. 3x + 2y = 0",
            "A. 50 m",
            "C. 100 m3",
            "B. 6x -8y = 483"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_mtk);

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