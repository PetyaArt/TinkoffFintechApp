package com.example.petya.tinkofffintech.network;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
