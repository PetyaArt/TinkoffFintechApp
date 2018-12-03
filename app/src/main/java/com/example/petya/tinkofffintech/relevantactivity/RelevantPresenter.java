package com.example.petya.tinkofffintech.relevantactivity;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.authactivity.AuthContract;
import com.example.petya.tinkofffintech.data.source.Repository;

import javax.inject.Inject;

public class RelevantPresenter implements RelevantContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private RelevantContract.View mAuthView;

    @Inject
    public RelevantPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(RelevantContract.View view) {
        this.mAuthView = view;
    }

    @Override
    public void dropView() {
        mAuthView = null;
    }

}
