package com.example.petya.tinkofffintech.activity.pastactivity.dagger;

import com.example.petya.tinkofffintech.activity.pastactivity.PastContract;
import com.example.petya.tinkofffintech.activity.pastactivity.PastFragment;
import com.example.petya.tinkofffintech.activity.pastactivity.PastPresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class PastModule {

    @ActivityScoped
    @Provides
    PastFragment relevantFragment() {
        return new PastFragment();
    }

    @ActivityScoped
    @Provides
    PastContract.Presenter relevantPresenter(Repository repository) {
        return new PastPresenter(repository);
    }
}
