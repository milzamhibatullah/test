package com.kristia_pembelajaran_videografi.kristia_videografi.User;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.PembelajaranFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.CameraAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.adapter.LensaAdapter;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.CameraResult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.lensaResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class LensaFragment extends Fragment {
    private RecyclerView recyclerViewCamera;
    private RecyclerView.Adapter adapter;
    private ImageView kembali;
    private TextView tittle;
    public LensaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lensa, container, false);


        return  rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Jenis Camera");


        recyclerViewCamera = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerViewCamera.setHasFixedSize(true);
        recyclerViewCamera.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewCamera.addItemDecoration(new DividerItemDecoration(recyclerViewCamera.getContext(), DividerItemDecoration.VERTICAL));
        kembali = (ImageView) view.findViewById(R.id.kembali);
        tittle = (TextView) view.findViewById(R.id.judul2);


        Bundle bundle = getArguments();
        if (bundle !=null) {
            String Judul = bundle.getString("title");

            if (Judul.equals("Movement Camera")) {
                tittle.setText("Movement Camera");
            } else if (Judul.equals("Jenis Camera")) {
                tittle.setText("Jenis Camera");
            } else if (Judul.equals("Jenis Lensa")) {
                tittle.setText("Jenis Lensa");
            }
        }
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


        Call<lensaResult> call = service.getLensa();

        call.enqueue(new Callback<lensaResult>() {
            @Override
            public void onResponse(Call<lensaResult> call, Response<lensaResult> response) {
                progressDialog.dismiss();
                adapter = new LensaAdapter(response.body().getResult(), getActivity());
                recyclerViewCamera.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<lensaResult> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}