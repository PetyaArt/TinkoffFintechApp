package com.example.petya.tinkofffintech.activity.statementcourseactivity;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.GroupedTask;

import java.util.List;

public interface StatementCourseContract {

    interface View extends BaseView<Presenter> {

        void offSwipeRefresh();

        void showNoInternet();

        void showError();

        void showData(Courses courses, List<GroupedTask> list);

    }

    interface Presenter extends BasePresenter<View> {

        void swipeSync();

    }
}
