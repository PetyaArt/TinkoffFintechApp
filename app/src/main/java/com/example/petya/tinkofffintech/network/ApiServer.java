package com.example.petya.tinkofffintech.network;

import com.example.petya.tinkofffintech.data.animedata.courses.Example;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

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

    @GET("api/course/android_fall2018/grades")
    Observable<JsonArray> getCource();
}
