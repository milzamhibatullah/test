package com.kristia_pembelajaran_videografi.kristia_videografi.Admin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.LensaFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.TampilTempatKursusFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.TutorialVideografiFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.kuis.QuisActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
     CardView belajr,kuis,tempt_kursus,tips;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        belajr = (CardView) rootView.findViewById(R.id.pembelajaran);
        kuis = (CardView) rootView.findViewById(R.id.quis);
        tempt_kursus = (CardView) rootView.findViewById(R.id.tmptkurusus);
        tips = (CardView) rootView.findViewById(R.id.tips);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(), QuisActivity.class);
                getActivity().startActivity(intent);
                //mengeksekusi fragment transaction
//                InputLensaFragment fragment = new InputLensaFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
//                String pesan = "jenis_lensa";
//                bundle.putString("pesan",pesan);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();
            }
        });

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                InputLensaFragment fragmentKedua = new InputLensaFragment();
//                //buat object fragmentkedua
//
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.frame_content, fragmentKedua)
//                        //menggant fragment
//                        .addToBackStack(null)
//                        //menyimpan fragment
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        //transisi fragment
//                        .commit();
//                //mengeksekusi fragment transaction

//                InputLensaFragment fragment = new InputLensaFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
//                String pesan = "movement_camera";
//                bundle.putString("pesan",pesan);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();
                TutorialVideografiFragment fragment = new TutorialVideografiFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                FT.replace(R.id.frame_content, fragment);
                FT.commit();
            }
        });

        tempt_kursus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TampilTempatKursusFragment fragment = new TampilTempatKursusFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                FT.replace(R.id.frame_content, fragment);
                FT.commit();
            }
        });

        belajr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                InputLensaFragment fragmentKedua = new InputLensaFragment();
//                //buat object fragmentkedua
//
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.frame_content, fragmentKedua)
//                        //menggant fragment
//                        .addToBackStack(null)
//                        //menyimpan fragment
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        //transisi fragment
//                        .commit();
//                //mengeksekusi fragment transaction


                PembelajaranFragment fragment = new PembelajaranFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                Bundle bundle = new Bundle();
                String pesan = "pembelajaran";
                bundle.putString("pesan",pesan);
                fragment.setArguments(bundle);
                FT.replace(R.id.frame_content, fragment);
                FT.commit();


            }
        });

    }

}
