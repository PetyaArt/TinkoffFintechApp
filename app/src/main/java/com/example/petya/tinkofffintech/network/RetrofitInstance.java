package com.example.petya.tinkofffintech.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL_FINTECH = "https://fintech.tinkoff.ru/";
    private static final String BASE_URL_UNSPLASH = "https://api.unsplash.com/";


    AddCookieInterceptor mAddCookieInterceptor;
    ReceivedCookiesInterceptor mReceivedCookiesInterceptor;

    public RetrofitInstance(AddCookieInterceptor addCookie, ReceivedCookiesInterceptor receivedCookies) {
        mAddCookieInterceptor = addCookie;
        mReceivedCookiesInterceptor = receivedCookies;
    }

    public RetrofitInstance() {
    }

    public ApiServer getApiServer() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL_FINTECH)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client( new OkHttpClient.Builder()
                        .addInterceptor(mAddCookieInterceptor)
                        .addInterceptor(mReceivedCookiesInterceptor)
                        .build()
                )
                .build();
        return builder.create(ApiServer.class);
    }

    public ApiUnsplash getApiUnsplash() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(BASE_URL_UNSPLASH)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return builder.create(ApiUnsplash.class);
    }
}
