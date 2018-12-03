package com.example.petya.tinkofffintech.pastactivity;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.event.Events;

public interface PastContract {

    interface View extends BaseView<Presenter> {

        void showNoInternet();

        void showError();

        void setAdapter(Events events);

    }

    interface Presenter extends BasePresenter<View> {

    }
}
