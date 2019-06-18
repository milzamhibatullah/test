package com.kristia_pembelajaran_videografi.kristia_videografi.models;

public class Tutorial_vediografi {
    public String judul;
    public String link_video;

    public Tutorial_vediografi(String  judul,String link_video){
        this.judul = judul;
        this.link_video = link_video;
    }

    public String getJudul() {
        return judul;
    }

    public String getLink_video() {
        return link_video;
    }
}
