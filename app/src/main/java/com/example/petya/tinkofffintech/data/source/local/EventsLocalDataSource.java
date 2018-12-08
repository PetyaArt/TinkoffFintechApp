package com.example.petya.tinkofffintech.data.source.local;

import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class EventsLocalDataSource {

    private final EventsDao mEventsDao;
    private final UnsplashDao mUnsplashDao;

    @Inject
    public EventsLocalDataSource(EventsDao eventsDao, UnsplashDao unsplashDao) {
        mEventsDao = eventsDao;
        mUnsplashDao = unsplashDao;
    }

    public Maybe<EventsData> getEventsLocalData() {
        return Maybe.zip(mUnsplashDao.getUnsplash(), mEventsDao.getEvents(),
                new BiFunction<Unsplash, Events, EventsData>() {
                    @Override
                    public EventsData apply(Unsplash unsplash, Events events) throws Exception {
                        return new EventsData(events, unsplash);
                    }
                });
    }

    public void insertOrUpdateUser(final EventsData events) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                mEventsDao.insert(events.getEvents());
                mUnsplashDao.insert(events.getUnsplash());
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
                mEventsDao.deleteAll();
                mUnsplashDao.deleteAll();
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
