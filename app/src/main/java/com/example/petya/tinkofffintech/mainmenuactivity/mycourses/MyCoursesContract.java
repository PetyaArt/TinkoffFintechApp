package com.example.petya.tinkofffintech.mainmenuactivity.mycourses;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.courses.Example;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsContract;

public interface MyCoursesContract {

    interface View extends BaseView<Presenter> {

        void showProgress();

        void hideProgress();

        void showNoInternet();

        void showError();

        void showData(Example example);
    }

    interface Presenter extends BasePresenter<View> {


    }
}
