package com.example.petya.tinkofffintech.authactivity;

import com.example.petya.tinkofffintech.di.ActivityScoped;
import com.example.petya.tinkofffintech.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AuthModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract AuthFragment authFragment();

    @ActivityScoped
    @Binds
    abstract AuthContract.Presenter authPresenter(AuthPresenter presenter);
}
