package com.example.petya.tinkofffintech.relevantactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.authactivity.AuthFragment;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;

public class RelevantActivity extends AppCompatActivity {

    @Inject
    RelevantPresenter mRelevantPresenter;

    @Inject
    Lazy<RelevantFragment> mRelevantFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relevant);
        //TODO: если успею добавить поиск
        App.getApp(this).getComponentsHolder().getRelevantActivityComponent().injectRelevantActivity(this);

        RelevantFragment relevantFragment =
                (RelevantFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameRelevant);
        if (relevantFragment == null) {
            relevantFragment = mRelevantFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), relevantFragment, R.id.contentFrameRelevant);
        }
    }
}