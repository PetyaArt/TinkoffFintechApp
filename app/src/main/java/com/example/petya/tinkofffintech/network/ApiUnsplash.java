package com.example.petya.tinkofffintech.network;

import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUnsplash {

    @GET("search/photos")
    Maybe<Unsplash> getLinkImage(@Query("client_id") String client_id, @Query("query") String season);
}
