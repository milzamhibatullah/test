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
import com.kristia_pembelajaran_videografi.kristia_videografi.api.ApiURL;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.CameraModel;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Sejarah;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SejarahAdapter extends RecyclerView.Adapter<SejarahAdapter.ViewHolder> {

    private List<Sejarah> sejarahresult;
    private Context mCtx;

    public SejarahAdapter(List<Sejarah> sejarahresult, Context mCtx) {
        this.sejarahresult = sejarahresult;
        this.mCtx = mCtx;
    }

    @Override
    public SejarahAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        SejarahAdapter.ViewHolder holder = new SejarahAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(SejarahAdapter.ViewHolder holder, int position) {
        final Sejarah sejarahlist = sejarahresult.get(position);
        holder.judul.setText(sejarahlist.getJudul());
//        holder.deskripsi.setText(sejarahlist.getDeskripsi());
//        Picasso.with(mCtx)
//                .load(ApiURL.getBaseUrlImage()+ sejarahlist.getGambar()).error(R.mipmap.arah)
//                .resize(500, 150)
//                .centerCrop()
//                .into(holder.gambar);

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx, DetailActivity.class);
                i.putExtra("judul",sejarahlist.getJudul());
                i.putExtra("deskripsi",sejarahlist.getDeskripsi());
                i.putExtra("gambar",sejarahlist.getGambar());
                String judul = "Sejarah";
                i.putExtra("title",judul);
                mCtx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sejarahresult.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView judul;
        //        public  TextView deskripsi;
//        public ImageView gambar;
        public ImageView detail;

        public ViewHolder(View itemView) {
            super(itemView);
            judul = (TextView) itemView.findViewById(R.id.judul1);
//            deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
//            gambar = (ImageView) itemView.findViewById(R.id.gambar);
            detail = (ImageView) itemView.findViewById(R.id.detail);
        }
    }
}
