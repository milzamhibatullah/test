package com.kristia_pembelajaran_videografi.kristia_videografi.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView,kembali;
    private TextView judul,deskripsi,tittle;
    String titleBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        imageView = (ImageView) findViewById(R.id.gambar);
        judul = (TextView) findViewById(R.id.judul);
        deskripsi = (TextView) findViewById(R.id.deskripsi);
        kembali = (ImageView) findViewById(R.id.btn_kembali);

        tittle = (TextView) findViewById(R.id.judul2);

        String Judul = getIntent().getStringExtra("judul");
        String Deskripsi = getIntent().getStringExtra("deskripsi");
        String Gambar = getIntent().getStringExtra("gambar");
        final String title = getIntent().getStringExtra("title");

        Log.d("LOG","JUDUL " + judul);
    }
}
