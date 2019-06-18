package com.kristia_pembelajaran_videografi.kristia_videografi.Admin;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.MovementCamera;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Result;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Tempatkursus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TempatKursusFragment extends Fragment {
private EditText nama_tmpt,alamat_tmpt,no_telp_tmpt,jam_buka_tmpt;
private Button simpan;

    public TempatKursusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_tempat_kursus, container, false);
        nama_tmpt = (EditText) rootView.findViewById(R.id.Nama);
        alamat_tmpt = (EditText) rootView.findViewById(R.id.alamat);
        no_telp_tmpt = (EditText) rootView.findViewById(R.id.notelp);
        jam_buka_tmpt = (EditText) rootView.findViewById(R.id.jambuka);
        simpan = (Button) rootView.findViewById(R.id.simpan);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }
        });

        return rootView;
    }


    private void simpan(){

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();

        String Nama = nama_tmpt.getText().toString().trim();
        String Alamat = alamat_tmpt.getText().toString().trim();
        String No_telp = no_telp_tmpt.getText().toString().trim();
        String Jam_buka = jam_buka_tmpt.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Defining retrofit api service
        VideografiAPI service = retrofit.create(VideografiAPI.class);

        Tempatkursus tempatkursus = new Tempatkursus(Nama,Alamat,No_telp,Jam_buka);

        Call<Result> call = service.sendtempatkursus(
                tempatkursus.getNama(),
                tempatkursus.getAlamat(),
                tempatkursus.getNo_telp(),
                tempatkursus.getJam_buka()
        );


        //calling the api
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //hiding progress dialog
                progressDialog.dismiss();
                Log.d("RETRO", "response : " + response.body().getKode());

                int kode = response.body().getKode();

                if(kode==1)
                {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
            }
        });
    }
}
