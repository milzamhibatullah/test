package com.kristia_pembelajaran_videografi.kristia_videografi.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.InputLensaFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.TampungFragmentActivity;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;

public class MainActivity extends AppCompatActivity {
private TextView belajr,kuis,tempt_kursus,tips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        belajr = (TextView) findViewById(R.id.pembelajaran);
        kuis = (TextView) findViewById(R.id.quis);
        tempt_kursus = (TextView) findViewById(R.id.tmptkurusus);
        tips = (TextView) findViewById(R.id.tips);

        belajr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                Intent i = new Intent(MainActivity.this, TampungFragmentActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
