package com.example.petya.tinkofffintech.network;

import android.content.Context;
import android.util.Log;

import com.example.petya.tinkofffintech.util.storage.Preferences;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookieInterceptor implements Interceptor {

    Context mContext;

    public AddCookieInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        Preferences preference = new Preferences(mContext);
        HashSet<String> preferences2 = (HashSet<String>) preference.getCookie();
        for (String cookie : preferences2) {
            builder.addHeader("Cookie", cookie);
            Log.v("myLogs", "Adding Header: " + cookie);
        }

        return chain.proceed(builder.build());
    }
}
