package com.example.petya.tinkofffintech.di;

import android.content.Context;

import com.example.petya.tinkofffintech.activity.authactivity.dagger.AuthActivityComponent;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.dagger.MainMenuComponent;
import com.example.petya.tinkofffintech.activity.pastactivity.dagger.PastActivityComponent;
import com.example.petya.tinkofffintech.activity.performanceactivity.dagger.PerformanceActivityComponent;
import com.example.petya.tinkofffintech.activity.relevantactivity.dagger.RelevantActivityComponent;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.dagger.StatementCourseComponent;
import com.example.petya.tinkofffintech.di.dagger.AppComponent;
import com.example.petya.tinkofffintech.di.dagger.AppModule;
import com.example.petya.tinkofffintech.di.dagger.DaggerAppComponent;

public class ComponentsHolder {

    private final Context context;

    private AppComponent mAppComponent;
    private AuthActivityComponent mAuthActivityComponent;
    private MainMenuComponent mMainMenuComponent;
    private RelevantActivityComponent mRelevantActivityComponent;
    private PastActivityComponent mPastActivityComponent;
    private PerformanceActivityComponent mPerformanceActivityComponent;
    private StatementCourseComponent mStatementCourseComponent;

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

    public void releaseAuthActivityComponent() {
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

    public void releaseRelevantActivityComponent() {
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

    public PerformanceActivityComponent getPerformanceActivityComponent() {
        if (mPerformanceActivityComponent == null) {
            mPerformanceActivityComponent = getAppComponent().createPerformanceActivityComponent();
        }
        return mPerformanceActivityComponent;
    }

    public void releasePerformanceActivityComponent() {
        mPerformanceActivityComponent = null;
    }


    public StatementCourseComponent getStatementCourseComponent() {
        if (mStatementCourseComponent == null) {
            mStatementCourseComponent = getAppComponent().createStatementCourseComponent();
        }
        return mStatementCourseComponent;
    }

    public void releaseStatementCourseComponent() {
        mPerformanceActivityComponent = null;
    }



}
