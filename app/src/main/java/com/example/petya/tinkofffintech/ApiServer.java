package com.example.petya.tinkofffintech;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServer {

    @POST("api/signin")
    Call<Object> singIn(@Body SingInBody singInBody);

    @GET("api/user")
    Call<Object> singIn2();

}
