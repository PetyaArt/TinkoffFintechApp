package com.example.petya.tinkofffintech.activity.statementcourseactivity;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.courses.GroupedTask;
import com.example.petya.tinkofffintech.data.animedata.courses.SubGrade;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StatementCoursePresenter implements StatementCourseContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private StatementCourseContract.View mStatementCourseView;

    @Inject
    public StatementCoursePresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(StatementCourseContract.View view) {
        this.mStatementCourseView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mStatementCourseView = null;
    }

    @Override
    public void swipeSync() {
        if (mStatementCourseView == null)
            return;
        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mStatementCourseView.showNoInternet();
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
                        List<GroupedTask> groupedTasks = new ArrayList<>();
                        for (List<GroupedTask> task :courses.getGroupedTasks()){
                            groupedTasks.addAll(task);
                        }
                        mStatementCourseView.showData(courses, groupedTasks);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mStatementCourseView.showError();
                        mStatementCourseView.offSwipeRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mStatementCourseView.offSwipeRefresh();
                    }
                });

    }


}
