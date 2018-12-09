package com.example.petya.tinkofffintech.activity.performanceactivity;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;

public interface PerformanceContract {

    interface View extends BaseView<Presenter> {

        void offSwipeRefresh();

        void showNoInternet();

        void showError();

        void showData(Courses courses);

    }

    interface Presenter extends BasePresenter<View> {

        void swipeSync();

    }
}
