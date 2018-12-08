package com.example.petya.tinkofffintech.network;

import android.content.Context;

import com.example.petya.tinkofffintech.util.storage.Preferences;

import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookieInterceptor implements Interceptor {

    private Context mContext;

    public AddCookieInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet<String>) new Preferences(mContext).getCookie();
        TreeSet<String> treeSet = new TreeSet<>(preferences);
        for (String cookie : treeSet) {
            builder.addHeader("Cookie", cookie);
        }
        return chain.proceed(builder.build());
    }
}
