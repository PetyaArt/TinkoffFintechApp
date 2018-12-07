package com.example.petya.tinkofffintech.mainmenuactivity.events;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.event.Events;

public interface EventsContract {

    interface View extends BaseView<Presenter> {

        void offSwipeRefresh();

        void showNoInternet();

        void showError();

        void setAdapter(EventsData eventsData);
    }

    interface Presenter extends BasePresenter<View> {

        void swipeRefresh();

    }
}
