package com.example.petya.tinkofffintech.activity.performanceactivity.dagger;

import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceActivity;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = PerformanceModule.class)
public interface PerformanceActivityComponent {
    void injectPerformanceActivity(PerformanceActivity relevantActivity);
    void injectPerformanceFragment(PerformanceFragment relevantFragment);
}
