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
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.PembelajaranFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.SejarahAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.Sejarahresult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SejarahActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCamera;
    private RecyclerView.Adapter adapter;
    ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sejarah);

        kembali = (ImageView) findViewById(R.id.kembali);
        recyclerViewCamera = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewCamera.setHasFixedSize(true);
        recyclerViewCamera.setLayoutManager(new LinearLayoutManager(SejarahActivity.this));
        recyclerViewCamera.addItemDecoration(new DividerItemDecoration(recyclerViewCamera.getContext(), DividerItemDecoration.VERTICAL));

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        tampildata();
    }

    private void tampildata(){

        final ProgressDialog progressDialog = new ProgressDialog(SejarahActivity.this);
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideografiAPI service = retrofit.create(VideografiAPI.class);


        Call<Sejarahresult> call = service.getSejarah();

        call.enqueue(new Callback<Sejarahresult>() {
            @Override
            public void onResponse(Call<Sejarahresult> call, Response<Sejarahresult> response) {
                progressDialog.dismiss();
                adapter = new SejarahAdapter(response.body().getResult(),SejarahActivity.this);
                recyclerViewCamera.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Sejarahresult> call, Throwable t) {
                Toast.makeText(SejarahActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
