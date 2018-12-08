package com.example.petya.tinkofffintech.activity.pastactivity;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.event.Events;

public interface PastContract {

    interface View extends BaseView<Presenter> {

        void offSwipeRefresh();

        void showNoInternet();

        void showError();

        void setAdapter(Events events);

    }

    interface Presenter extends BasePresenter<View> {

        void swipeSync();

    }
}
