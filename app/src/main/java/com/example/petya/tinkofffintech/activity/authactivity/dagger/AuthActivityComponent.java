package com.example.petya.tinkofffintech.activity.authactivity.dagger;

import com.example.petya.tinkofffintech.activity.authactivity.AuthActivity;
import com.example.petya.tinkofffintech.activity.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = AuthModule.class)
public interface AuthActivityComponent {
    void injectAuthActivity(AuthActivity authActivity);
    void injectAuthFragment(AuthFragment authFragment);
}
