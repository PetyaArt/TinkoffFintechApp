package com.example.petya.tinkofffintech.activity.relevantactivity.dagger;

import com.example.petya.tinkofffintech.activity.relevantactivity.RelevantContract;
import com.example.petya.tinkofffintech.activity.relevantactivity.RelevantFragment;
import com.example.petya.tinkofffintech.activity.relevantactivity.RelevantPresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

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
