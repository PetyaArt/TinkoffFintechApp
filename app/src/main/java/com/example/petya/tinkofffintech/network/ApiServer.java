package com.example.petya.tinkofffintech.network;

import com.example.petya.tinkofffintech.data.animedata.availablecourses.AvailableCourses;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServer {

    @POST("api/signin")
    Observable<JsonObject> singIn(@Body SingInBody singInBody);

    @GET("api/user")
    Observable<Profile> getProfileInfo();

    @GET("api/calendar/list/event")
    Maybe<Events> getEvents();

    @GET("api/course/android_fall2018/grades")
    Observable<JsonArray> getCource();

    @GET("api/connections")
    Observable<AvailableCourses> getAvailableCourses();

    @POST("api/signout")
    Single<Response<Void>> signOut();
}
