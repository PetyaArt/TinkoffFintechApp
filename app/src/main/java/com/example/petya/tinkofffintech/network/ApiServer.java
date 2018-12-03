package com.example.petya.tinkofffintech.network;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServer {

    @POST("api/signin")
    Observable<Profile> singIn(@Body SingInBody singInBody);

    @GET("api/user")
    Observable<Profile> getProfileInfo();

    @GET("api/calendar/list/event")
    Observable<Events> getEvents();
}
