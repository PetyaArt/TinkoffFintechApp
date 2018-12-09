package com.example.petya.tinkofffintech.activity.mainmenuactivity.events;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class EventsPresenter implements EventsContract.Presenter {

    public final static String KEY = "bf5e348de3daca8f75ad68aef72b58b4b8a44e45fa1adb4f9f69d17b1f58a3ef";

    private final Repository mRepository;

    @Nullable
    private EventsContract.View mEventsView;
    private Object Object;

    public EventsPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(EventsContract.View view) {
        mEventsView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mEventsView = null;
    }

    @Override
    public void swipeSync() {
        if (mEventsView == null)
            return;
        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mEventsView.showNoInternet();
        }
        Maybe.concat(mRepository.getEventsLocalDataSource().getEventsLocalData(), getEventsData())
                .firstElement()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<EventsData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(EventsData eventsData) {
                        mEventsView.setAdapter(eventsData);
                        mEventsView.offSwipeRefresh();
                        saveDataDb(eventsData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mEventsView.showError();
                        mEventsView.offSwipeRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mEventsView.offSwipeRefresh();
                    }
                });
    }

    private void saveDataDb(EventsData eventsData) {
        mRepository.getEventsLocalDataSource().insertOrUpdateUser(eventsData);
    }

    private Maybe<EventsData> getEventsData() {
        return Maybe.zip(mRepository.getApiUnsplash().getLinkImage(KEY, "spring"),
                mRepository.getApiServer().getEvents(),
                new BiFunction<Unsplash, Events, EventsData>() {
                    @Override
                    public EventsData apply(Unsplash unsplash, Events events) throws Exception {
                        return new EventsData(events, unsplash);
                    }
                });
    }
}
