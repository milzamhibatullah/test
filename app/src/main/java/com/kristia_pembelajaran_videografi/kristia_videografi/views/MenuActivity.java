package com.kristia_pembelajaran_videografi.kristia_videografi.views;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.PembelajaranFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.TampilTempatKursusFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.TutorialVideografiFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.kuis.QuisActivity;

public class MenuActivity extends AppCompatActivity {
    CardView belajr,kuis,tempt_kursus,tips;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        belajr = (CardView) findViewById(R.id.pembelajaran);
        kuis = (CardView) findViewById(R.id.quis);
        tempt_kursus = (CardView) findViewById(R.id.tmptkurusus);
        tips = (CardView) findViewById(R.id.tips);

        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MenuActivity.this, QuisActivity.class);
                startActivity(intent);
//                finish();
                //mengeksekusi fragment transaction
//                InputLensaFragment fragment = new InputLensaFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
//                String pesan = "jenis_lensa";
//                bundle.putString("pesan",pesan);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                InputLensaFragment fragmentKedua = new InputLensaFragment();
//                //buat object fragmentkedua
//
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.frame_content, fragmentKedua)
//                        //menggant fragment
//                        .addToBackStack(null)
//                        //menyimpan fragment
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        //transisi fragment
//                        .commit();
//                //mengeksekusi fragment transaction

//                InputLensaFragment fragment = new InputLensaFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
//                String pesan = "movement_camera";
//                bundle.putString("pesan",pesan);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();
//                TutorialVideografiFragment fragment = new TutorialVideografiFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();
                Intent intent = new Intent(MenuActivity.this, TutorialVideGrafiActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        tempt_kursus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TampilTempatKursusFragment fragment = new TampilTempatKursusFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();
                Intent intent = new Intent(MenuActivity.this, DaftarTempatKursusActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        belajr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                InputLensaFragment fragmentKedua = new InputLensaFragment();
//                //buat object fragmentkedua
//
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.frame_content, fragmentKedua)
//                        //menggant fragment
//                        .addToBackStack(null)
//                        //menyimpan fragment
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        //transisi fragment
//                        .commit();
//                //mengeksekusi fragment transaction


//                PembelajaranFragment fragment = new PembelajaranFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
                String pesan = "pembelajaran";
//                bundle.putString("pesan",pesan);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();

                Intent intent = new Intent(MenuActivity.this, PembelajaranActivity.class);
                intent.putExtra("pesan",pesan);
                startActivity(intent);
//                finish();

            }
        });
    }
}
