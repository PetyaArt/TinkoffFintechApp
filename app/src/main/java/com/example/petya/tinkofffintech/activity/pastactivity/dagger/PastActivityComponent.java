package com.example.petya.tinkofffintech.activity.pastactivity.dagger;

import com.example.petya.tinkofffintech.activity.pastactivity.PastActivity;
import com.example.petya.tinkofffintech.activity.pastactivity.PastFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = PastModule.class)
public interface PastActivityComponent {
    void injectPastActivity(PastActivity relevantActivity);
    void injectPastFragment(PastFragment relevantFragment);
}
