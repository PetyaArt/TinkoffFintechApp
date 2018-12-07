package com.example.petya.tinkofffintech.util.storage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Preferences {

    final static String FILE_NAME = "preferences";

    public final static String COOKIES = "cookie";

    public SharedPreferences mPreferences;

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
