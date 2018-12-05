package com.example.petya.tinkofffintech.pastactivity.dagger;

import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.pastactivity.PastContract;
import com.example.petya.tinkofffintech.pastactivity.PastFragment;
import com.example.petya.tinkofffintech.pastactivity.PastPresenter;

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
