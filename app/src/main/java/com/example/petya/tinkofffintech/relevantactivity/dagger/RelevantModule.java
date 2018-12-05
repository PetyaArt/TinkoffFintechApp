package com.example.petya.tinkofffintech.relevantactivity.dagger;

import com.example.petya.tinkofffintech.authactivity.AuthContract;
import com.example.petya.tinkofffintech.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.authactivity.AuthPresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.relevantactivity.RelevantContract;
import com.example.petya.tinkofffintech.relevantactivity.RelevantFragment;
import com.example.petya.tinkofffintech.relevantactivity.RelevantPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RelevantModule {

    @ActivityScoped
    @Provides
    RelevantFragment relevantFragment() {
        return new RelevantFragment();
    }

    @ActivityScoped
    @Provides
    RelevantContract.Presenter relevantPresenter(Repository repository) {
        return new RelevantPresenter(repository);
    }
}
