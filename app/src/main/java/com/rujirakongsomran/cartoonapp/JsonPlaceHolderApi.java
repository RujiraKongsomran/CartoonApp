package com.rujirakongsomran.cartoonapp;

import com.rujirakongsomran.cartoonapp.model.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("/RujiraKongsomran/JsonAnime/main/AnimeData.json")
    Call<List<Anime>> getListAnime();
}
