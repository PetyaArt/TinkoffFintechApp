package com.example.petya.tinkofffintech.authactivity.dagger;

import com.example.petya.tinkofffintech.authactivity.AuthContract;
import com.example.petya.tinkofffintech.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.authactivity.AuthPresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;

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
