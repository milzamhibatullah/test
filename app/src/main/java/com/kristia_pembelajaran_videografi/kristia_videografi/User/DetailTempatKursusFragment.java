package com.kristia_pembelajaran_videografi.kristia_videografi.User;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.MainFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTempatKursusFragment extends Fragment {
    private ImageView imageView,back;
    private TextView nama,alamat,no_telp,jam;

    public DetailTempatKursusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_tempat_kursus, container, false);

        back = (ImageView) rootView.findViewById(R.id.kembali);

        nama = (TextView) rootView.findViewById(R.id.nama);
        alamat = (TextView) rootView.findViewById(R.id.alamat);
        no_telp = (TextView) rootView.findViewById(R.id.no_telp);
        jam = (TextView) rootView.findViewById(R.id.jam);

        Bundle bundle = getArguments();
        String Nama = bundle.getString("nama");
        String Alamat = bundle.getString("alamat");
        String No_telp = bundle.getString("no_telp");
        String Jam_buka = bundle.getString("jam_buka");
//
        nama.setText(Nama);
        alamat.setText(Alamat);
        no_telp.setText(No_telp);
        jam.setText(Jam_buka);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TampilTempatKursusFragment fragmentKedua = new TampilTempatKursusFragment();
                //buat object fragmentkedua

                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_content, fragmentKedua)
                        //menggant fragment
                        .addToBackStack(null)
                        //menyimpan fragment
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        //transisi fragment
                        .commit();
//                //mengeksekusi fragment transaction
            }
        });

        return rootView;
    }

}
