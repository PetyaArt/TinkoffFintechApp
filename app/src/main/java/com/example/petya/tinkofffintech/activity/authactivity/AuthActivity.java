package com.example.petya.tinkofffintech.activity.authactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.util.Utils;

import javax.inject.Inject;

import dagger.Lazy;

public class AuthActivity extends AppCompatActivity {

    @Inject
    Lazy<AuthFragment> mAuthFragmentLazyProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        App.getApp(this).getComponentsHolder().getAuthActivityComponent().injectAuthActivity(this);

        AuthFragment authFragment =
                (AuthFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (authFragment == null) {
            authFragment = mAuthFragmentLazyProvider.get();
            Utils.addFragmentToActivity(
                    getSupportFragmentManager(), authFragment, R.id.contentFrame);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseAuthActivityComponent();
        }
    }
}
