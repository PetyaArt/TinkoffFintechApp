package com.example.petya.tinkofffintech.util.storage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class Preferences {

    private final static String FILE_NAME = "preferences";

    private final static String COOKIES = "cookie";

    private SharedPreferences mPreferences;

    private static final Object LOCK = new Object();

    public Preferences(Context context) {
        mPreferences = context.getSharedPreferences(FILE_NAME, 0);
    }

    public void setCookies(HashSet<String> cookies) {
        synchronized (LOCK) {
            mPreferences.edit().putStringSet(COOKIES, cookies).apply();
        }
    }

    public Set<String> getCookie() {
        synchronized (LOCK) {
            return mPreferences.getStringSet(COOKIES, new HashSet<String>());
        }
    }
}
