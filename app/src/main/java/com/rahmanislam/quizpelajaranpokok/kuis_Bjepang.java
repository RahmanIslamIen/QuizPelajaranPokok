package com.rahmanislam.quizpelajaranpokok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kuis_Bjepang extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Ucapan yang digunakan untuk mengucapkan Selamat pagi adalah…",
            "2. “Buku saya” dirubah kedalam bahasa jepang menjadi",
            "3. “Tsu ku ru ka “ Apabila dirubah menjadi huruf hiragana menjadi",
            "4. “Watashi wa indonesia jin desu”. Arti dari kalimat disamping adalah",
            "5. Untuk mengawali perkenalan menggunakan ungkapan ="
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "a. Ohayou gozaimasu", "b. Konnichiwa", "c. Sayoonara", "d. Konbanwa",
            "a. Watashi wa hon desu", "b. Watashi no hon desu", " c. Anata no hon desu", "d. Hon no Watashi desu",
            "a. す　る　ぐ　ば", "b. つ　る　く　か", "c. つ　く　る　か", "d. す　く　る　か",
            "a. Saya bukan orang indonesia", "b. Saya orang malasya", "c. Saya bukan  indonesia", "d. Saya orang indonesia",
            "a. arigatou gozaimasu", "b. Oyamsumi nasai", "c. Hajimemashite", "d. Sayounara"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "a. Ohayou gozaimasu",
            "b. Watashi no hon desu",
            "c. つ　く　る　か",
            "d. Saya orang indonesia",
            "c. Hajimemashite"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_bjepang);

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