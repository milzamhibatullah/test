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
import com.kristia_pembelajaran_videografi.kristia_videografi.models.MovementCamera;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.MovementCameraModel;

import java.util.List;

public class MovementCameraAdapter extends RecyclerView.Adapter<MovementCameraAdapter.ViewHolder> {

    private List<MovementCamera> movementresult;
    private Context mCtx;

    public MovementCameraAdapter(List<MovementCamera> movementresult, Context mCtx) {
        this.movementresult = movementresult;
        this.mCtx = mCtx;
    }

    @Override
    public MovementCameraAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        MovementCameraAdapter.ViewHolder holder = new MovementCameraAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MovementCameraAdapter.ViewHolder holder, int position) {
        final  MovementCamera movementlist = movementresult.get(position);
        holder.judul.setText(movementlist.getJudul());

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx, DetailActivity.class);
                i.putExtra("judul",movementlist.getJudul());
                i.putExtra("deskripsi",movementlist.getDeskripsi());
                i.putExtra("gambar",movementlist.getGambar());
                String judul = "Movement Camera";
                i.putExtra("judul","Movement Camera");
                mCtx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movementresult.size();
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
