package com.example.petya.tinkofffintech.di;

import android.content.Context;

import com.example.petya.tinkofffintech.authactivity.dagger.AuthActivityComponent;
import com.example.petya.tinkofffintech.di.dagger.AppComponent;
import com.example.petya.tinkofffintech.di.dagger.AppModule;
import com.example.petya.tinkofffintech.di.dagger.DaggerAppComponent;

public class ComponentsHolder {

    private final Context context;

    private AppComponent mAppComponent;
    private AuthActivityComponent mAuthActivityComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    void init() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }


    // FirstActivityComponent

    public AuthActivityComponent getAuthActivityComponent() {
        if (mAuthActivityComponent == null) {
            mAuthActivityComponent = getAppComponent().createAuthActivityComponent();
        }
        return mAuthActivityComponent;
    }

    public void releaseFirstActivityComponent() {
        mAuthActivityComponent = null;
    }



}
