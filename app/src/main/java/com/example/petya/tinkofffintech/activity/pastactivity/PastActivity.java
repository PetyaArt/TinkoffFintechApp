package com.example.petya.tinkofffintech.activity.pastactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.util.Utils;

import javax.inject.Inject;

import dagger.Lazy;

public class PastActivity extends AppCompatActivity {

    @Inject
    PastPresenter mRelevantPresenter;

    @Inject
    Lazy<PastFragment> mPastFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past);

        App.getApp(this).getComponentsHolder().getPastActivityComponent().injectPastActivity(this);

        PastFragment relevantFragment =
                (PastFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (relevantFragment == null) {
            relevantFragment = mPastFragmentProvider.get();
            Utils.addFragmentToActivity(
                    getSupportFragmentManager(), relevantFragment, R.id.contentFrame);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releasePastActivityComponent();
        }
    }
}
