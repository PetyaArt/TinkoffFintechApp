package com.example.petya.tinkofffintech.authactivity.dagger;

import com.example.petya.tinkofffintech.authactivity.AuthActivity;
import com.example.petya.tinkofffintech.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;

import dagger.Subcomponent;

@FragmentScoped
@ActivityScoped
@Subcomponent(modules = AuthModule.class)
public interface AuthActivityComponent {
    void injectAuthActivity(AuthActivity authActivity);
    void injectAuthFragment(AuthFragment authFragment);
}
