package com.example.petya.tinkofffintech.di;

import android.content.Context;

import com.example.petya.tinkofffintech.authactivity.dagger.AuthActivityComponent;
import com.example.petya.tinkofffintech.di.dagger.AppComponent;
import com.example.petya.tinkofffintech.di.dagger.AppModule;
import com.example.petya.tinkofffintech.di.dagger.DaggerAppComponent;
import com.example.petya.tinkofffintech.mainmenuactivity.dagger.MainMenuComponent;
import com.example.petya.tinkofffintech.pastactivity.dagger.PastActivityComponent;
import com.example.petya.tinkofffintech.relevantactivity.dagger.RelevantActivityComponent;

public class ComponentsHolder {

    private final Context context;

    private AppComponent mAppComponent;
    private AuthActivityComponent mAuthActivityComponent;
    private MainMenuComponent mMainMenuComponent;
    private RelevantActivityComponent mRelevantActivityComponent;
    private PastActivityComponent mPastActivityComponent;

    public ComponentsHolder(Context context) {
        this.context = context;
    }

    void init() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public AuthActivityComponent getAuthActivityComponent() {
        if (mAuthActivityComponent == null) {
            mAuthActivityComponent = getAppComponent().createAuthActivityComponent();
        }
        return mAuthActivityComponent;
    }

    public void releaseFirstActivityComponent() {
        mAuthActivityComponent = null;
    }


    public MainMenuComponent getMainMenuComponent() {
        if (mMainMenuComponent == null) {
            mMainMenuComponent = getAppComponent().createMainMenuComponent();
        }
        return mMainMenuComponent;
    }

    public void releaseMainMenuComponent() {
        mMainMenuComponent = null;
    }

    public RelevantActivityComponent getRelevantActivityComponent() {
        if (mRelevantActivityComponent == null) {
            mRelevantActivityComponent = getAppComponent().createRelevantActivityComponent();
        }
        return mRelevantActivityComponent;
    }

    public void releaseRelevantActivityComponentt() {
        mRelevantActivityComponent = null;
    }

    public PastActivityComponent getPastActivityComponent() {
        if (mPastActivityComponent == null) {
            mPastActivityComponent = getAppComponent().createPastActivityComponent();
        }
        return mPastActivityComponent;
    }

    public void releasePastActivityComponent() {
        mPastActivityComponent = null;
    }

}
