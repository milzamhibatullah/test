package com.kristia_pembelajaran_videografi.kristia_videografi.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;

public class DetailTempatKursusActivity extends AppCompatActivity {

    private ImageView imageView,back;
    private TextView nama,alamat,no_telp,jam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat_kursus);
        back = (ImageView) findViewById(R.id.kembali);

        nama = (TextView) findViewById(R.id.nama);
        alamat = (TextView) findViewById(R.id.alamat);
        no_telp = (TextView) findViewById(R.id.no_telp);
        jam = (TextView) findViewById(R.id.jam);


        String Nama = getIntent().getStringExtra("nama");
        String Alamat = getIntent().getStringExtra("alamat");
        String No_telp = getIntent().getStringExtra("no_telp");
        String Jam_buka = getIntent().getStringExtra("jam_buka");
//
        nama.setText(Nama);
        alamat.setText(Alamat);
        no_telp.setText(No_telp);
        jam.setText(Jam_buka);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
