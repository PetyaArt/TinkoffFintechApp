package com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.availablecourses.AvailableCourses;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

public interface MyCoursesContract {

    interface View extends BaseView<Presenter> {

        void offSwipeRefresh();

        void showNoInternet();

        void showError();

        void showData(Courses courses);

        void setAvailableCourses(AvailableCourses courses);
    }

    interface Presenter extends BasePresenter<View> {

        void swipeSync();
    }
}
