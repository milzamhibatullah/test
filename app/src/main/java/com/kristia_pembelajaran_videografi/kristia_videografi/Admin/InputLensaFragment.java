package com.kristia_pembelajaran_videografi.kristia_videografi.Admin;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.VideografiAPI;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.CameraModel;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.LensaModel;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.MovementCamera;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Result;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Sejarah;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputLensaFragment extends Fragment  {
private Button simpan;
private EditText judul,deskripsi;
private ImageView imageView;
    String Pesan;
    private  static final int IMAGE = 100;
    Bitmap bitmap;
    public InputLensaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_input_lensa, container, false);
        judul = (EditText) rootView.findViewById(R.id.judul);
        deskripsi = (EditText) rootView.findViewById(R.id.deskripsi);
        imageView = (ImageView) rootView.findViewById(R.id.gambar);
        simpan = (Button) rootView.findViewById(R.id.simpan);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pesan.equals("pembelajaran")){
                    simpan();
                }else if (Pesan.equals("jenis_lensa")){
                    simpanlensa();
                }else if (Pesan.equals("movement_camera")){
                    simpanmovementcamera();
                }else if (Pesan.equals("Sejarah")){
                    simpansejarah();
                }
            }
        });
        Bundle bundle = getArguments();
         Pesan = bundle.getString("pesan");

        judul.setText(Pesan);
        return rootView;
    }
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE);
    }
    private String convertToString()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte,Base64.DEFAULT);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== IMAGE && resultCode==RESULT_OK && data!=null)
        {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void  simpan(){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();

        String Judul = judul.getText().toString().trim() ;
        String Deskripsi = deskripsi.getText().toString().trim();
        String Gambar = convertToString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Defining retrofit api service
        VideografiAPI service = retrofit.create(VideografiAPI.class);

        CameraModel cameraModel = new CameraModel(Judul,Deskripsi,Gambar);

        Call<Result> call = service.sendcamera(
                            cameraModel.getJudul(),
                           cameraModel.getDeskripsi(),
                            cameraModel.getGambar()
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

    public void  simpanlensa(){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();

        String Judul = judul.getText().toString().trim() ;
        String Deskripsi = deskripsi.getText().toString().trim();
        String Gambar = convertToString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Defining retrofit api service
        VideografiAPI service = retrofit.create(VideografiAPI.class);

        LensaModel lensaModel = new LensaModel(Judul,Deskripsi,Gambar);

        Call<Result> call = service.sendlensa(
                lensaModel.getJudul(),
                lensaModel.getDeskripsi(),
                lensaModel.getGambar()
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

    public void  simpanmovementcamera(){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Prosessingg...");
        progressDialog.show();

        String Judul = judul.getText().toString().trim() ;
        String Deskripsi = deskripsi.getText().toString().trim();
        String Gambar = convertToString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiURL.BASE_URL_1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Defining retrofit api service
        VideografiAPI service = retrofit.create(VideografiAPI.class);

        MovementCamera movementCamera = new MovementCamera(Judul,Deskripsi,Gambar);

        Call<Result> call = service.sendmovementcamera(
                movementCamera.getJudul(),
                movementCamera.getDeskripsi(),
                movementCamera.getGambar()
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

public void simpansejarah(){
    final ProgressDialog progressDialog = new ProgressDialog(getContext());
    progressDialog.setMessage("Prosessingg...");
    progressDialog.show();

    String Judul = judul.getText().toString().trim() ;
    String Deskripsi = deskripsi.getText().toString().trim();
    String Gambar = convertToString();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiURL.BASE_URL_1)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    //Defining retrofit api service
    VideografiAPI service = retrofit.create(VideografiAPI.class);

    Sejarah sejarah = new Sejarah(Judul,Deskripsi,Gambar);

    Call<Result> call = service.sendsejarah(
            sejarah.getJudul(),
            sejarah.getDeskripsi(),
            sejarah.getGambar()
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
