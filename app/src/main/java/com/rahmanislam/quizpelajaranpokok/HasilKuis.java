package com.rahmanislam.quizpelajaranpokok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilKuis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);
        int benarPKN = MainActivity.benar;
        int benarBinggris = kuis_Binggris.benar;
        int benarMtk = kuis_mtk.benar;
        int benarFisika = kuis_fisika.benar;
        int benarBindo = kuis_Bindo.benar;
        int benarBjepang = kuis_Bjepang.benar;

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        TextView padapelajaran = (TextView) findViewById(R.id.pdPelajaran);

            if(benarPKN > 0){
                padapelajaran.setText("PKN");
                hasil.setText("Jawaban Benar :"+MainActivity.benar+"\nJawaban Salah :"+MainActivity.salah);
                nilai.setText(""+MainActivity.hasil);
            }
            if(benarBinggris > 0){
                padapelajaran.setText("B INGGRIS");
                hasil.setText("Jawaban Benar :"+kuis_Binggris.benar+"\nJawaban Salah :"+kuis_Binggris.salah);
                nilai.setText(""+kuis_Binggris.hasil);
            }
            if(benarMtk > 0){
                padapelajaran.setText("Matematika");
                hasil.setText("Jawaban Benar :"+kuis_mtk.benar+"\nJawaban Salah :"+kuis_mtk.salah);
                nilai.setText(""+kuis_mtk.hasil);
            }
            if(benarFisika > 0){
                padapelajaran.setText("Fisika");
                hasil.setText("Jawaban Benar :"+kuis_fisika.benar+"\nJawaban Salah :"+kuis_fisika.salah);
                nilai.setText(""+kuis_fisika.hasil);
            }
            if(benarBindo > 0){
                padapelajaran.setText("Bahasa Indonesia");
                hasil.setText("Jawaban Benar :"+kuis_Bindo.benar+"\nJawaban Salah :"+kuis_Bindo.salah);
                nilai.setText(""+kuis_Bindo.hasil);
            }
            if(benarBjepang > 0){
                padapelajaran.setText("Bahasa Jepang");
                hasil.setText("Jawaban Benar :"+kuis_Bjepang.benar+"\nJawaban Salah :"+kuis_Bjepang.salah);
                nilai.setText(""+kuis_Bjepang.hasil);
            }

            if(benarPKN+benarBinggris+benarMtk+benarFisika+benarBindo+benarBjepang == 0 ){
                padapelajaran.setText("OOPS");
                hasil.setText("Salah Semua Coba Belajar Lagi");
                nilai.setText("0");
            }
    }

    public void ulangi(View view){
        onDestroy();
        finish();
        Intent a = new Intent(getApplicationContext(),pilihan_kuis.class);
        startActivity(a);
    }
}