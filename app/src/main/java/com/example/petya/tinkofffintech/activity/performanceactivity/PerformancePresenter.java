package com.example.petya.tinkofffintech.activity.performanceactivity;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

import static com.example.petya.tinkofffintech.activity.mainmenuactivity.events.EventsPresenter.KEY;

public class PerformancePresenter implements PerformanceContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private PerformanceContract.View mPerformanceView;

    @Inject
    public PerformancePresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(PerformanceContract.View view) {
        this.mPerformanceView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mPerformanceView = null;
    }

    @Override
    public void swipeSync() {
        if (mPerformanceView == null)
            return;
        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mPerformanceView.showNoInternet();
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
                        mPerformanceView.showData(courses);
                        mRepository.getCoursesLocalDataSource().insertCourses(courses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mPerformanceView.showError();
                        mPerformanceView.offSwipeRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mPerformanceView.offSwipeRefresh();
                    }
                });

    }


}
