package com.kristia_pembelajaran_videografi.kristia_videografi.models;

public class Tempatkursus {
    private  String nama;
    private  String alamat;
    private String no_telp;
    private  String jam_buka;

    public Tempatkursus(String nama,String alamat,String  no_telp, String jam_buka){
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
        this.jam_buka = jam_buka;

    }

    public String getNama() {
        return nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJam_buka() {
        return jam_buka;
    }
}
