package com.example.petya.tinkofffintech.activity.authactivity.dagger;

import com.example.petya.tinkofffintech.activity.authactivity.AuthContract;
import com.example.petya.tinkofffintech.activity.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.activity.authactivity.AuthPresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class AuthModule {

    @ActivityScoped
    @Provides
    AuthFragment authFragment() {
        return new AuthFragment();
    }

    @ActivityScoped
    @Provides
    AuthContract.Presenter authPresenter(Repository repository) {
        return new AuthPresenter(repository);
    }
}
