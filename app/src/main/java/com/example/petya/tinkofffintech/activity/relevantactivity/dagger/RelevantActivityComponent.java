package com.example.petya.tinkofffintech.activity.relevantactivity.dagger;

import com.example.petya.tinkofffintech.activity.relevantactivity.RelevantActivity;
import com.example.petya.tinkofffintech.activity.relevantactivity.RelevantFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = RelevantModule.class)
public interface RelevantActivityComponent {
    void injectRelevantActivity(RelevantActivity relevantActivity);
    void injectRelevantFragment(RelevantFragment relevantFragment);
}
