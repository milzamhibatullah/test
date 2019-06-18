package com.kristia_pembelajaran_videografi.kristia_videografi.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.Deatil_Fragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.DetailTempatKursusFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.CameraModel;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Tempatkursus;
import com.kristia_pembelajaran_videografi.kristia_videografi.views.DetailTempatKursusActivity;

import java.util.List;

public class TempatKursusAdapter extends RecyclerView.Adapter<TempatKursusAdapter.ViewHolder>{
    private List<Tempatkursus> temparkursusresult;
    private Context mCtx;

    public TempatKursusAdapter(List<Tempatkursus> temparkursusresult, Context mCtx) {
        this.temparkursusresult = temparkursusresult;
        this.mCtx = mCtx;
    }
    @Override
    public TempatKursusAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        TempatKursusAdapter.ViewHolder holder = new TempatKursusAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(TempatKursusAdapter.ViewHolder holder, int position) {
        final  Tempatkursus tempatkursuslist = temparkursusresult.get(position);
        holder.judul.setText(tempatkursuslist.getNama());

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx, DetailTempatKursusActivity.class);
                i.putExtra("nama",tempatkursuslist.getNama());
                i.putExtra("alamat",tempatkursuslist.getAlamat());
                i.putExtra("no_telp",tempatkursuslist.getNo_telp());
                i.putExtra("jam_buka",tempatkursuslist.getJam_buka());
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temparkursusresult.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView judul;
        public  TextView deskripsi;
        public ImageView detail;

        public ViewHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.judul1);
            deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            detail = (ImageView) itemView.findViewById(R.id.detail);
        }
    }
}
