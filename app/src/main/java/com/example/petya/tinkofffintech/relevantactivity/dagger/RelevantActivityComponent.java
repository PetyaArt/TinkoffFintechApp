package com.example.petya.tinkofffintech.relevantactivity.dagger;

import com.example.petya.tinkofffintech.authactivity.AuthActivity;
import com.example.petya.tinkofffintech.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.authactivity.dagger.AuthModule;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.relevantactivity.RelevantActivity;
import com.example.petya.tinkofffintech.relevantactivity.RelevantFragment;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = RelevantModule.class)
public interface RelevantActivityComponent {
    void injectRelevantActivity(RelevantActivity relevantActivity);
    void injectRelevantFragment(RelevantFragment relevantFragment);
}
