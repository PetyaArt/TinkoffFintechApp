package com.example.petya.tinkofffintech.di.dagger;

import com.example.petya.tinkofffintech.authactivity.dagger.AuthActivityComponent;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    AuthActivityComponent createAuthActivityComponent();
}
