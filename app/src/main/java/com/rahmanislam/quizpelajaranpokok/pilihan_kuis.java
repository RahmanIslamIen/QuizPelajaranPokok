package com.rahmanislam.quizpelajaranpokok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pilihan_kuis extends AppCompatActivity {
    Button pkn,Binggris,Matematika,Fisika,Bindo,Bjepang;
    Intent quizPkn,quizBinggris,quizMatematika,quizFisika,quizBindo,quizBjepang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_kuis);

        pkn = (Button)findViewById(R.id.btnPkn);
        Binggris = (Button)findViewById(R.id.btnBinggris);
        Matematika = (Button)findViewById(R.id.btnMtk);
        Fisika = (Button)findViewById(R.id.btnFisika);
        Bindo = (Button)findViewById(R.id.btnBindo);
        Bjepang = (Button)findViewById(R.id.btnBjepang);

        pkn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizPkn = new Intent(pilihan_kuis.this, MainActivity.class);
                startActivity(quizPkn);
                finish();
            }
        });

        Binggris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBinggris = new Intent(pilihan_kuis.this, kuis_Binggris.class);
                startActivity(quizBinggris);
                finish();
            }
        });

        Matematika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizMatematika = new Intent(pilihan_kuis.this, kuis_mtk.class);
                startActivity(quizMatematika);
                finish();
            }
        });

        Fisika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizFisika = new Intent(pilihan_kuis.this, kuis_fisika.class);
                startActivity(quizFisika);
                finish();
            }
        });

        Bindo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBindo = new Intent(pilihan_kuis.this, kuis_Bindo.class);
                startActivity(quizBindo);
                finish();
            }
        });

        Bjepang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBjepang = new Intent(pilihan_kuis.this, kuis_Bjepang.class);
                startActivity(quizBjepang);
                finish();
            }
        });

    }
}