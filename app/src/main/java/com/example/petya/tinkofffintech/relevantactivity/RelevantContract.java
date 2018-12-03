package com.example.petya.tinkofffintech.relevantactivity;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;

public interface RelevantContract {

    interface View extends BaseView<Presenter> {

        void showNoInternet();

        void showError();

    }

    interface Presenter extends BasePresenter<View> {

    }
}
