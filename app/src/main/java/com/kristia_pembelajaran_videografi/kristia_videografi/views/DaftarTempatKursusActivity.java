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

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.MainFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.TempatKursusAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.TempatKursusResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaftarTempatKursusActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCamera;
    private RecyclerView.Adapter adapter;

    private ImageView kembali;
    TextView tittle;
    String Judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_tempat_kursus);
        recyclerViewCamera = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewCamera.setHasFixedSize(true);
        recyclerViewCamera.setLayoutManager(new LinearLayoutManager(DaftarTempatKursusActivity.this));
        recyclerViewCamera.addItemDecoration(new DividerItemDecoration(recyclerViewCamera.getContext(), DividerItemDecoration.VERTICAL));

        kembali = (ImageView) findViewById(R.id.kembali);

        tittle = (TextView) findViewById(R.id.judul2);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               finish();

            }
        });
        tampildata();
    }

    private void tampildata(){
        final ProgressDialog progressDialog = new ProgressDialog(DaftarTempatKursusActivity.this);
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideografiAPI service = retrofit.create(VideografiAPI.class);


        Call<TempatKursusResult> call = service.getTempatkursus();

        call.enqueue(new Callback<TempatKursusResult>() {
            @Override
            public void onResponse(Call<TempatKursusResult> call, Response<TempatKursusResult> response) {
                progressDialog.dismiss();
                adapter = new TempatKursusAdapter(response.body().getResult(), DaftarTempatKursusActivity.this);
                recyclerViewCamera.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<TempatKursusResult> call, Throwable t) {
                Toast.makeText(DaftarTempatKursusActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
