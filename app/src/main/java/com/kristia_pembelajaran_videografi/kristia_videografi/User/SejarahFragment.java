package com.kristia_pembelajaran_videografi.kristia_videografi.User;


import android.app.ProgressDialog;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.PembelajaranFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.CameraAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.SejarahAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.CameraResult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.Sejarahresult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class SejarahFragment extends Fragment {
    private RecyclerView recyclerViewCamera;
    private RecyclerView.Adapter adapter;
    ImageView kembali;


    public SejarahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sejarah, container, false);
        kembali = (ImageView) rootView.findViewById(R.id.kembali);
        recyclerViewCamera = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerViewCamera.setHasFixedSize(true);
        recyclerViewCamera.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewCamera.addItemDecoration(new DividerItemDecoration(recyclerViewCamera.getContext(), DividerItemDecoration.VERTICAL));

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    PembelajaranFragment fragmentKedua = new PembelajaranFragment();
                    //buat object fragmentkedua

                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, fragmentKedua)
                            //menggant fragment
                            .addToBackStack(null)
                            //menyimpan fragment
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            //transisi fragment
                            .commit();


            }
        });

        tampildata();
        return rootView;
    }


    private void tampildata(){

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
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
                adapter = new SejarahAdapter(response.body().getResult(), getActivity());
                recyclerViewCamera.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Sejarahresult> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
