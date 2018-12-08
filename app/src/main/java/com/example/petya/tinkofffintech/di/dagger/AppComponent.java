package com.example.petya.tinkofffintech.di.dagger;

import com.example.petya.tinkofffintech.activity.authactivity.dagger.AuthActivityComponent;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.dagger.MainMenuComponent;
import com.example.petya.tinkofffintech.activity.pastactivity.dagger.PastActivityComponent;
import com.example.petya.tinkofffintech.activity.relevantactivity.dagger.RelevantActivityComponent;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    AuthActivityComponent createAuthActivityComponent();
    MainMenuComponent createMainMenuComponent();
    RelevantActivityComponent createRelevantActivityComponent();
    PastActivityComponent createPastActivityComponent();
}
