package com.kristia_pembelajaran_videografi.kristia_videografi.Admin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.main.MainActivity;

public class TampungFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampung_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
       /* *getSupportFragmentManager = inisialisasi nilai FragmentManager untuk berinteraksi
            dengan Activity saat ini
         */
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //memulai transaction fragment manager

        MainFragment inputLensaFragment = new MainFragment();
        //membuat object fragmentPertama
        transaction.add(R.id.frame_content, inputLensaFragment);
        //menambahkan fragment
        transaction.addToBackStack("fragmentPertama");
        //dapat menyimpan fragment ke dalam state ,ketika tombol back diklik
        transaction.commit();
        //mengeksekusi fragment transaction
    }

}
