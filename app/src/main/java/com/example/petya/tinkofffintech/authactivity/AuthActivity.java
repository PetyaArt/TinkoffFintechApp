package com.example.petya.tinkofffintech.authactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String CURRENT_FILTERING_KEY = "CURRENT_FILTERING_KEY";
    @Inject
    AuthPresenter mAuthPresenter;

    @Inject
    Lazy<AuthFragment> authFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        AuthFragment authFragment =
                (AuthFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (authFragment == null) {
            authFragment = authFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), authFragment, R.id.contentFrame);
        }
    }
}
