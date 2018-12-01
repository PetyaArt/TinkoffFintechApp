package com.example.petya.tinkofffintech.di;

import com.example.petya.tinkofffintech.authactivity.AuthActivity;
import com.example.petya.tinkofffintech.authactivity.AuthModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = AuthModule.class)
    abstract AuthActivity authActivity();
}
