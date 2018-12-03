package com.example.petya.tinkofffintech.mainmenuactivity.events;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.event.Events;

public interface EventsContract {

    interface View extends BaseView<EventsContract.Presenter> {

        void showProgress();

        void hideProgress();

        void showNoInternet();

        void showError();

        void setAdapter(Events events);
    }

    interface Presenter extends BasePresenter<EventsContract.View> {


    }
}
