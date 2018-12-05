package com.example.petya.tinkofffintech.mainmenuactivity.mycourses;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.petya.tinkofffintech.data.animedata.courses.Example;
import com.example.petya.tinkofffintech.data.source.Repository;
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
        mRepository.getApiServer().getCource()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonArray>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonArray jsonArray) {
                        Example example = new Gson().fromJson(jsonArray.get(1), Example.class);
                        mMyCoursesView.showData(example);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("myLogs2", String.valueOf(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void dropView() {
        mMyCoursesView = null;
    }
}
