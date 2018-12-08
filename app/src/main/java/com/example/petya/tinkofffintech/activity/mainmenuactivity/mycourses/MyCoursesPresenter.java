package com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.availablecourses.AvailableCourses;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyCoursesPresenter implements MyCoursesContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private MyCoursesContract.View mMyCoursesView;

    public MyCoursesPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(MyCoursesContract.View view) {
        mMyCoursesView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mMyCoursesView = null;
    }

    @Override
    public void swipeSync() {
        if (mMyCoursesView == null)
            return;
        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mMyCoursesView.showNoInternet();
        }
        mRepository.getApiServer().getCource()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonArray>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonArray jsonArray) {
                        Courses courses = new Gson().fromJson(jsonArray.get(1), Courses.class);
                        mMyCoursesView.showData(courses);
                        mRepository.getCoursesLocalDataSource().insertCourses(courses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMyCoursesView.showError();
                        mMyCoursesView.offSwipeRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mMyCoursesView.offSwipeRefresh();
                    }
                });

        mRepository.getApiServer().getAvailableCourses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AvailableCourses>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AvailableCourses availableCourses) {
                        mMyCoursesView.setAvailableCourses(availableCourses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMyCoursesView.showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
