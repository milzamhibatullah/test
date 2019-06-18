package com.kristia_pembelajaran_videografi.kristia_videografi.models;

public class MovementCamera {
    public String judul;
    public String deskripsi;
    public  String gambar;

    public  MovementCamera(String judul,String deskripsi,String gambar){
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public String getGambar() {
        return gambar;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
