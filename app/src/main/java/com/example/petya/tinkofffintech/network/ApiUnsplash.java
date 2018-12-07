package com.example.petya.tinkofffintech.network;

import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUnsplash {

    @GET("search/photos")
    Flowable<Unsplash> getLinkImage(@Query("client_id") String client_id, @Query("query") String season);
}
