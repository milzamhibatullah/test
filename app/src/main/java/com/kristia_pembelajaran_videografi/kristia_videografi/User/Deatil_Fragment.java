package com.kristia_pembelajaran_videografi.kristia_videografi.User;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.MainFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.PembelajaranFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.squareup.picasso.Picasso;

import javax.security.auth.Destroyable;

/**
 * A simple {@link Fragment} subclass.
 */
public class Deatil_Fragment extends Fragment {
private ImageView imageView,kembali;
private TextView judul,deskripsi,tittle;
String titleBar;


    Context mContext;
    public Deatil_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_deatil_, container, false);
        imageView = (ImageView) rootView.findViewById(R.id.gambar);
        judul = (TextView) rootView.findViewById(R.id.judul);
        deskripsi = (TextView) rootView.findViewById(R.id.deskripsi);
        kembali = (ImageView) rootView.findViewById(R.id.btn_kembali);

        tittle = (TextView) rootView.findViewById(R.id.judul2);
        mContext=getContext();
        Bundle bundle = getArguments();
        String Judul = bundle.getString("judul");
        String Deskripsi = bundle.getString("deskripsi");
        String Gambar = bundle.getString("gambar");
        final String title = bundle.getString("title");

        Log.d("LOG","JUDUL " + judul);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("LOG","BUTTON NYA APA" + judul);
                if (title.equals("Movement Camera")){
                    MovementFragment fragmentKedua = new MovementFragment();
                    //buat object fragmentkedua

                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, fragmentKedua)
                            //menggant fragment
                            .addToBackStack(null)
                            //menyimpan fragment
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            //transisi fragment
                            .commit();
                    //mengeksekusi fragment transaction
                }else if (title.equals("Jenis Camera")){
                    CameraFragment fragmentKedua = new CameraFragment();
                    //buat object fragmentkedua

                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, fragmentKedua)
                            //menggant fragment
                            .addToBackStack(null)
                            //menyimpan fragment
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            //transisi fragment
                            .commit();
                    //mengeksekusi fragment transaction
                }else if (title.equals("Jenis Lensa")) {
                    LensaFragment fragmentKedua = new LensaFragment();
                    //buat object fragmentkedua

                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, fragmentKedua)
                            //menggant fragment
                            .addToBackStack(null)
                            //menyimpan fragment
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            //transisi fragment
                            .commit();
                    //mengeksekusi fragment transaction
                }else if (title.equals("Sejarah")) {
                    SejarahFragment fragmentKedua = new SejarahFragment();
                    //buat object fragmentkedua

                    getFragmentManager().beginTransaction()
                            .replace(R.id.frame_content, fragmentKedua)
                            //menggant fragment
                            .addToBackStack(null)
                            //menyimpan fragment
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            //transisi fragment
                            .commit();
                    //mengeksekusi fragment transaction
                }


            }
        });

        if (title.equals("Movement Camera")){
            tittle.setText("Movement Camera");
        }else if (title.equals("Jenis Camera")){
            tittle.setText("Jenis Camera");
        }else if (title.equals("Jenis Lensa"))
        {
            tittle.setText("Jenis Lensa");
        }

        judul.setText(Judul);
        deskripsi.setText(Deskripsi);
        Picasso.with(mContext)
                .load(ApiURL.getBaseUrlImage()+ Gambar).error(R.drawable.no_image)
                .resize(500, 150)
                .centerCrop()
                .into(this.imageView);




        return rootView;
    }

}
