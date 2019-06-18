package com.kristia_pembelajaran_videografi.kristia_videografi.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView,back;
    private TextView judul,deskripsi,tittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = (ImageView) findViewById(R.id.gambar);
        judul = (TextView) findViewById(R.id.judul);
        deskripsi = (TextView) findViewById(R.id.deskripsi);
        back = (ImageView) findViewById(R.id.back);
        tittle = (TextView) findViewById(R.id.judul2);

        String Judul = getIntent().getStringExtra("judul");
        String Deskripsi = getIntent().getStringExtra("deskripsi");
        String Gambar = getIntent().getStringExtra("gambar");
        final String title = getIntent().getStringExtra("title");

        Log.d("LOG","JUDUL " + judul);

//       if (title.equals("Jenis Camera")){
//            tittle.setText("Jenis Camera");
//        }else if (title.equals("Jenis Lensa"))
//        {
//            tittle.setText("Jenis Lensa");
//        }else {
//            tittle.setText("Movement Camera");
//        }

        judul.setText(Judul);
        deskripsi.setText(Deskripsi);
        Picasso.with(DetailActivity.this)
                .load(ApiURL.getBaseUrlImage()+ Gambar).error(R.drawable.no_image)
                .resize(500, 150)
                .centerCrop()
                .into(this.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
