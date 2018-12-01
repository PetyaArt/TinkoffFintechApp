package com.example.petya.tinkofffintech.network;

import android.content.Context;

import com.example.petya.tinkofffintech.AddCookieInterceptor;
import com.example.petya.tinkofffintech.ApiServer;
import com.example.petya.tinkofffintech.ReceivedCookiesInterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://fintech.tinkoff.ru/";

    Context mContext;

    public RetrofitInstance(Context context) {
        mContext = context;
    }

    public ApiServer getApiServer() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client( new OkHttpClient.Builder()
                        .addInterceptor(new AddCookieInterceptor(mContext))
                        .addInterceptor(new ReceivedCookiesInterceptor(mContext))
                        .build()
                )
                .build();
        return builder.create(ApiServer.class);
    }
}
