package com.kristia_pembelajaran_videografi.kristia_videografi.api;

import com.kristia_pembelajaran_videografi.kristia_videografi.models.Result;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.CameraResult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.MovementResult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.Sejarahresult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.TempatKursusResult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.Tutorial_videografiResult;
import com.kristia_pembelajaran_videografi.kristia_videografi.value.lensaResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface VideografiAPI {
    @FormUrlEncoded
    @POST("camera.php")
    Call<Result> sendcamera(@Field("judul") String judul,
                            @Field("deskripsi") String deskripsi,
                            @Field("gambar") String gambar
    );

    @FormUrlEncoded
    @POST("jenis_camera.php")
    Call<Result> sendlensa(@Field("judul") String judul,
                           @Field("deskripsi") String deskripsi,
                           @Field("gambar") String gambar
    );

    @FormUrlEncoded
    @POST("movement_camera.php")
    Call<Result> sendmovementcamera(@Field("judul") String judul,
                                    @Field("deksripsi") String deskripsi,
                                    @Field("gambar") String gambar
    );
    @FormUrlEncoded
    @POST("sejarah.php")
    Call<Result> sendsejarah(@Field("judul") String judul,
                                    @Field("deskripsi") String deskripsi,
                                    @Field("gambar") String gambar
    );

    @FormUrlEncoded
    @POST("tempat_kursus.php")
    Call<Result> sendtempatkursus(@Field("nama") String nama,
                                  @Field("alamat") String alamat,
                                  @Field("no_telp") String no_telp,
                                  @Field("jam_buka") String jam_buka

    );


    //getting messages
    @GET("tampil_camera.php")
    Call<CameraResult> getCamera();

    //getting messages
    @GET("tampil_movement_camera.php")
    Call<MovementResult> getMovementCamera();

    //getting messages
    @GET("tampil_lensa.php")
    Call<lensaResult> getLensa();

    //getting messages
    @GET("tampil_tempat_kursus.php")
    Call<TempatKursusResult> getTempatkursus();

    @FormUrlEncoded
    @POST("tutorial_videografi.php")
    Call<Result> sendtutorialvideo(@Field("judul") String judul,
                                    @Field("link_video") String link_video
    );

    //getting messages
    @GET("tampil_tutorial_videografi.php")
    Call<Tutorial_videografiResult> getTutorial();
    //getting messages
    @GET("tampil_sejarah.php")
    Call<Sejarahresult> getSejarah();
}
