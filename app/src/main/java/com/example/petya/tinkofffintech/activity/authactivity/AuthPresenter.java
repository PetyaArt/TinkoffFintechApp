package com.example.petya.tinkofffintech.activity.authactivity;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.network.SingInBody;
import com.example.petya.tinkofffintech.util.Utils;
import com.google.gson.JsonObject;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class AuthPresenter implements AuthContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private AuthContract.View mAuthView;

    @Inject
    public AuthPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(AuthContract.View view) {
        this.mAuthView = view;
    }

    @Override
    public void dropView() {
        mAuthView = null;
    }


    @Override
    public void buttonPress(String login, final String password) {
        if (mAuthView == null)
            return;
        mAuthView.showProgress();
        if (login.equals("") || password.equals("")) {
            mAuthView.showFieldEmpty();
            mAuthView.hideProgress();
        } else if(!Utils.isOnline(mRepository.getConnectivityManager())) {
            mAuthView.showNoInternet();
            mAuthView.hideProgress();
        } else {
            mRepository.getApiServer().singIn(new SingInBody(login, password))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<JsonObject>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }
                        @Override
                        public void onNext(JsonObject jsonObject) {
                            mAuthView.openActivity();
                        }
                        @Override
                        public void onError(Throwable e) {
                            mAuthView.hideProgress();
                            mAuthView.showError();
                        }
                        @Override
                        public void onComplete() {
                            mAuthView.hideProgress();
                        }
                    });

        }
    }

}
