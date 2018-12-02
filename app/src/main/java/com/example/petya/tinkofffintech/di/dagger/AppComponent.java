package com.example.petya.tinkofffintech.di.dagger;

import com.example.petya.tinkofffintech.authactivity.dagger.AuthActivityComponent;
import com.example.petya.tinkofffintech.mainmenuactivity.dagger.MainMenuComponent;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    AuthActivityComponent createAuthActivityComponent();
    MainMenuComponent createMainMenuComponent();
}
