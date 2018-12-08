package com.example.petya.tinkofffintech.data.source.local;

import com.example.petya.tinkofffintech.data.animedata.courses.Courses;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class CoursesLocalDataSource {

    private final ProfileDao mProfileDao;
    private final CoursesDao mCoursesDao;

    @Inject
    public CoursesLocalDataSource(ProfileDao profileDao, CoursesDao coursesDao) {
        mProfileDao = profileDao;
        mCoursesDao = coursesDao;
    }

    public void insertCourses(final Courses courses) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mCoursesDao.insert(courses);
            }})
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void deleteAllUsers() {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mCoursesDao.deleteAll();
                mProfileDao.deleteAll();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
