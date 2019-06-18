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
import com.kristia_pembelajaran_videografi.kristia_videografi.User.DetailActivity;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.CameraModel;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.LensaModel;

import java.util.List;

public class LensaAdapter extends RecyclerView.Adapter<LensaAdapter.ViewHolder>  {

    private List<LensaModel> lensaresult;
    private Context mCtx;

    public LensaAdapter(List<LensaModel> lensaresult, Context mCtx) {
        this.lensaresult = lensaresult;
        this.mCtx = mCtx;
    }

    @Override
    public LensaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        LensaAdapter.ViewHolder holder = new LensaAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(LensaAdapter.ViewHolder holder, int position) {
        final  LensaModel lensalist = lensaresult.get(position);
        holder.judul.setText(lensalist.getJudul());

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx, DetailActivity.class);
                i.putExtra("judul",lensalist.getJudul());
                i.putExtra("deskripsi",lensalist.getDeskripsi());
                i.putExtra("gambar",lensalist.getGambar());
                String judul = "Jenis Lensa";
                i.putExtra("title",judul);
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lensaresult.size();
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
