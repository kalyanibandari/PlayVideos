package com.example.playvideos.api;

import com.example.playvideos.model.PlayVideosObj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    String videoPathType = "/media.json";

    @GET(videoPathType)
    Call<List<PlayVideosObj>> getVideosList(@Query(value = "print") String pretty);
}
