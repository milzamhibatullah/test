package com.kristia_pembelajaran_videografi.kristia_videografi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.kristia_pembelajaran_videografi.kristia_videografi.models.CameraModel;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.Tutorial_vediografi;

import java.util.List;

public class Tutorial_videografiAdapter  extends RecyclerView.Adapter<Tutorial_videografiAdapter.ViewHolder> {

    private List<Tutorial_vediografi> tutorial_vediografis;
    private Context mCtx;

    public Tutorial_videografiAdapter(List<Tutorial_vediografi> tutorial_vediografis, Context mCtx) {
        this.tutorial_vediografis = tutorial_vediografis;
        this.mCtx = mCtx;
    }
    @Override
    public Tutorial_videografiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        Tutorial_videografiAdapter.ViewHolder holder = new Tutorial_videografiAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(Tutorial_videografiAdapter.ViewHolder holder, int position) {
        final  Tutorial_vediografi tutorial_vediografilist = tutorial_vediografis.get(position);
        holder.judul.setText(tutorial_vediografilist.getJudul());


        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = tutorial_vediografilist.link_video;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                intent.putExtra("VIDEO_ID", link);
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tutorial_vediografis.size();
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
