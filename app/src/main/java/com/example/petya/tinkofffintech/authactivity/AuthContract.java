package com.example.petya.tinkofffintech.authactivity;

import android.text.Editable;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;

public interface AuthContract {

    interface View extends BaseView<Presenter> {

        void showProgress();

        void hideProgress();

        void showNoInternet();

        void showError();

        void showFieldEmpty();
    }

    interface Presenter extends BasePresenter<View> {

        void buttonPress(String text, String mPasswordText);
    }
}
