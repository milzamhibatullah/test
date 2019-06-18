package com.kristia_pembelajaran_videografi.kristia_videografi.views;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.MainFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.Tutorial_videografiAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.Tutorial_videografiResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TutorialVideGrafiActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCamera;
    private RecyclerView.Adapter adapter;
    private ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_vide_grafi);

        recyclerViewCamera = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewCamera.setHasFixedSize(true);
        recyclerViewCamera.setLayoutManager(new LinearLayoutManager(TutorialVideGrafiActivity.this));
        recyclerViewCamera.addItemDecoration(new DividerItemDecoration(recyclerViewCamera.getContext(), DividerItemDecoration.VERTICAL));

        kembali = (ImageView) findViewById(R.id.kembali);

        tampildata();

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }

    private void tampildata(){

        final ProgressDialog progressDialog = new ProgressDialog(TutorialVideGrafiActivity.this);
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideografiAPI service = retrofit.create(VideografiAPI.class);


        Call<Tutorial_videografiResult> call = service.getTutorial();

        call.enqueue(new Callback<Tutorial_videografiResult>() {
            @Override
            public void onResponse(Call<Tutorial_videografiResult> call, Response<Tutorial_videografiResult> response) {
                progressDialog.dismiss();
                adapter = new Tutorial_videografiAdapter(response.body().getResult(), TutorialVideGrafiActivity.this);
                recyclerViewCamera.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Tutorial_videografiResult> call, Throwable t) {
                Toast.makeText(TutorialVideGrafiActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
