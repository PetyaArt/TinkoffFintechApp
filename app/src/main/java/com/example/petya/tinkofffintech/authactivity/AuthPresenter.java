package com.example.petya.tinkofffintech.authactivity;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;

import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.network.SingInBody;

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
    public void buttonPress(String login, String password) {
        if (mAuthView != null) {
            mAuthView.showProgress();
        }
        if (login.equals("") || password.equals("")) {
            if (mAuthView != null) {
                mAuthView.showFieldEmpty();
                mAuthView.hideProgress();
            }
        } else {
            mRepository.getApiServer().singIn(new SingInBody(login, password))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Profile>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Profile profile) {
                            Log.d("myLogs", String.valueOf(profile.getStatus()));
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d("myLogs", String.valueOf(e));
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
