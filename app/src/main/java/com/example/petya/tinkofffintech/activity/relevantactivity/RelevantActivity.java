package com.example.petya.tinkofffintech.activity.relevantactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.util.Utils;

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

        App.getApp(this).getComponentsHolder().getRelevantActivityComponent().injectRelevantActivity(this);

        RelevantFragment relevantFragment =
                (RelevantFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrameRelevant);
        if (relevantFragment == null) {
            relevantFragment = mRelevantFragmentProvider.get();
            Utils.addFragmentToActivity(
                    getSupportFragmentManager(), relevantFragment, R.id.contentFrameRelevant);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseRelevantActivityComponent();
        }
    }
}
