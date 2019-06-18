package com.kristia_pembelajaran_videografi.kristia_videografi.views;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.MainFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.CameraFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.LensaFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.MovementFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.SejarahFragment;

public class PembelajaranActivity extends AppCompatActivity {
    private CardView movement, lensa, camera, sejarah;
    private ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelajaran);
        lensa = (CardView) findViewById(R.id.lensa);
        camera = (CardView) findViewById(R.id.camera);
        sejarah = (CardView) findViewById(R.id.sejarah);
        kembali = (ImageView) findViewById(R.id.kembali);
        movement = (CardView) findViewById(R.id.Movement);
        movement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                String judul = "Movement Camera";

                Intent i = new Intent(PembelajaranActivity.this, MovementCameraActivity.class);
                i.putExtra("title",judul);
                startActivity(i);
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();

            }
        });
        lensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String judul = "Jenis Lensa";


                Intent i = new Intent(PembelajaranActivity.this, LensaActivity.class);
                i.putExtra("title",judul);
                startActivity(i);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String judul = "Jenis Camera";

                Intent i = new Intent(PembelajaranActivity.this, CameraActivity.class);
                i.putExtra("title",judul);
                startActivity(i);
            }
        });

        sejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                InputLensaFragment fragment = new InputLensaFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
                String judul = "Sejarah";
//                bundle.putString("pesan",judul);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();

//                SejarahFragment fragment = new SejarahFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();



                Intent i = new Intent(PembelajaranActivity.this, SejarahActivity.class);
                i.putExtra("title",judul);
                startActivity(i);
            }
        });

    }
}
