package com.example.petya.tinkofffintech.authactivity;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;

public interface AuthContract {

    interface View extends BaseView<Presenter> {

        void showProgress();

        void hideProgress();


    }

    interface Presenter extends BasePresenter {

    }
}
