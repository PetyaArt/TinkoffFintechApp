package com.example.petya.tinkofffintech.activity.mainmenuactivity.events;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.EventsData;

public interface EventsContract {

    interface View extends BaseView<Presenter> {

        void offSwipeRefresh();

        void showNoInternet();

        void showError();

        void setAdapter(EventsData eventsData);
    }

    interface Presenter extends BasePresenter<View> {

        void swipeSync();

    }
}
