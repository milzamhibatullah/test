package com.kristia_pembelajaran_videografi.kristia_videografi.Admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.CameraFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.LensaFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.MovementFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.SejarahFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Sejarah;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class PembelajaranFragment extends Fragment {
    private CardView movement, lensa, camera, sejarah;
    private ImageView kembali;

    public PembelajaranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pembelajaran, container, false);

        movement = (CardView) rootView.findViewById(R.id.Movement);
        lensa = (CardView) rootView.findViewById(R.id.lensa);
        camera = (CardView) rootView.findViewById(R.id.camera);
        sejarah = (CardView) rootView.findViewById(R.id.sejarah);
        kembali = (ImageView) rootView.findViewById(R.id.kembali);
        movement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovementFragment fragment = new MovementFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                Bundle bundle = new Bundle();
                String judul = "Movement Camera";
                bundle.putString("title", judul);
                fragment.setArguments(bundle);
                FT.replace(R.id.frame_content, fragment);
                FT.commit();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment fragmentKedua = new MainFragment();
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
        lensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LensaFragment fragment = new LensaFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                Bundle bundle = new Bundle();
                String judul = "Jenis Lensa";
                bundle.putString("title", judul);
                fragment.setArguments(bundle);
                FT.replace(R.id.frame_content, fragment);
                FT.commit();
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraFragment fragment = new CameraFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                Bundle bundle = new Bundle();
                String judul = "Jenis Camera";
                bundle.putString("title", judul);
                fragment.setArguments(bundle);
                FT.replace(R.id.frame_content, fragment);
                FT.commit();
            }
        });

        sejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                InputLensaFragment fragment = new InputLensaFragment();
//                FragmentManager FM = getActivity().getSupportFragmentManager();
//                FragmentTransaction FT = FM.beginTransaction();
//
//
//                Bundle bundle = new Bundle();
//                String judul = "Sejarah";
//                bundle.putString("pesan",judul);
//                fragment.setArguments(bundle);
//                FT.replace(R.id.frame_content, fragment);
//                FT.commit();

                SejarahFragment fragment = new SejarahFragment();
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();


                Bundle bundle = new Bundle();
                String judul = "Sejarah Camera";
                bundle.putString("title", judul);
                fragment.setArguments(bundle);
                FT.replace(R.id.frame_content, fragment);
                FT.commit();
            }
        });
        return rootView;
    }
}