package com.example.petya.tinkofffintech.activity.performanceactivity.dagger;

import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceContract;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceFragment;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformancePresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class PerformanceModule {

    @ActivityScoped
    @Provides
    PerformanceFragment performanceFragment() {
        return new PerformanceFragment();
    }

    @ActivityScoped
    @Provides
    PerformanceContract.Presenter relevantPresenter(Repository repository) {
        return new PerformancePresenter(repository);
    }
}
