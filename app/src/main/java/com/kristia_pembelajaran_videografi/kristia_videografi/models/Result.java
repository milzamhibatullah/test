package com.kristia_pembelajaran_videografi.kristia_videografi.models;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("value")
    int  kode;
    @SerializedName("message")
    private String message;
    public Result(int kode,String message ) {

        this.kode = kode;
        this.message = message;
    }

    public int getKode() {
        return kode;
    }

    public String getMessage() {
        return message;
    }
}
