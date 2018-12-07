package com.example.petya.tinkofffintech.network;

import android.content.Context;
import android.util.Log;

import com.example.petya.tinkofffintech.util.storage.Preferences;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;

public class ReceivedCookiesInterceptor implements Interceptor {

    private Context mContext;

    public ReceivedCookiesInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse  = chain.proceed(chain.request());
        Preferences preferences = new Preferences(mContext);

        if (originalResponse.networkResponse().request().url().toString().contains("signin")) {
            HashSet<String> cookies = new HashSet<>(originalResponse.headers("Set-Cookie"));
            preferences.setCookies(cookies);
        }

        return originalResponse;
    }
}
