package com.kristia_pembelajaran_videografi.kristia_videografi.views;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.PembelajaranFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.LensaAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.lensaResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LensaActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCamera;
    private RecyclerView.Adapter adapter;
    private ImageView kembali;
    private TextView tittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lensa);


        recyclerViewCamera = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewCamera.setHasFixedSize(true);
        recyclerViewCamera.setLayoutManager(new LinearLayoutManager(LensaActivity.this));
        recyclerViewCamera.addItemDecoration(new DividerItemDecoration(recyclerViewCamera.getContext(), DividerItemDecoration.VERTICAL));
        kembali = (ImageView) findViewById(R.id.kembali);
        tittle = (TextView) findViewById(R.id.judul2);

        String Judul = getIntent().getStringExtra("title");

        if (Judul.equals("Movement Camera")) {
            tittle.setText("Movement Camera");
        } else if (Judul.equals("Jenis Camera")) {
            tittle.setText("Jenis Camera");
        } else if (Judul.equals("Jenis Lensa")) {
            tittle.setText("Jenis Lensa");
        }
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PembelajaranFragment fragmentKedua = new PembelajaranFragment();
                //buat object fragmentkedua

                finish();
            }
        });
        tampildata();
    }

    private void tampildata() {

        final ProgressDialog progressDialog = new ProgressDialog(LensaActivity.this);
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideografiAPI service = retrofit.create(VideografiAPI.class);


        Call<lensaResult> call = service.getLensa();

        call.enqueue(new Callback<lensaResult>() {
            @Override
            public void onResponse(Call<lensaResult> call, Response<lensaResult> response) {
                if (response.isSuccessful()) {


                    progressDialog.dismiss();
                    adapter = new LensaAdapter(response.body().getResult(), LensaActivity.this);
                    recyclerViewCamera.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<lensaResult> call, Throwable t) {
                Toast.makeText(LensaActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
