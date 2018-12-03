package com.example.petya.tinkofffintech.relevantactivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class RelevantFragment extends Fragment implements RelevantContract.View {

    @Inject
    RelevantContract.Presenter mPresenter;

    @Inject
    public RelevantFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            //App.getApp(getContext()).getComponentsHolder().getAuthActivityComponent().injectAuthFragment(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_relevant, container, false);
    }

    @Override
    public void showNoInternet() {

    }

    @Override
    public void showError() {

    }
}
