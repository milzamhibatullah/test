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

import com.kristia_pembelajaran_videografi.kristia_videografi.Admin.InputLensaFragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.R;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.Deatil_Fragment;
import com.kristia_pembelajaran_videografi.kristia_videografi.User.DetailActivity;
import com.kristia_pembelajaran_videografi.kristia_videografi.models.CameraModel;

import java.net.JarURLConnection;
import java.util.List;

public class CameraAdapter extends RecyclerView.Adapter<CameraAdapter.ViewHolder> {
        private List<CameraModel> cameraresult;
        private Context mCtx;

    public CameraAdapter(List<CameraModel> cameraresult, Context mCtx) {
        this.cameraresult = cameraresult;
        this.mCtx = mCtx;
    }
    @Override
    public CameraAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false);
        CameraAdapter.ViewHolder holder = new CameraAdapter.ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(CameraAdapter.ViewHolder holder, int position) {
        final  CameraModel cameralist = cameraresult.get(position);
        holder.judul.setText(cameralist.getJudul());

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mCtx, DetailActivity.class);
                i.putExtra("judul",cameralist.getJudul());
                i.putExtra("deskripsi",cameralist.getDeskripsi());
                i.putExtra("gambar",cameralist.getGambar());
                String judul = "Jenis Camera";
                i.putExtra("title",judul);
                mCtx.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return cameraresult.size();
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
