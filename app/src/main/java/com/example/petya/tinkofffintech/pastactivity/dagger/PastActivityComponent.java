package com.example.petya.tinkofffintech.pastactivity.dagger;

import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.pastactivity.PastActivity;
import com.example.petya.tinkofffintech.pastactivity.PastFragment;

import dagger.Subcomponent;

@FragmentScoped
@ActivityScoped
@Subcomponent(modules = PastModule.class)
public interface PastActivityComponent {
    void injectPastActivity(PastActivity relevantActivity);
    void injectPastFragment(PastFragment relevantFragment);
}
