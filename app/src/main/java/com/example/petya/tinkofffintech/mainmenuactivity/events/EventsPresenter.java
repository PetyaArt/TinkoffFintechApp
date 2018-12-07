package com.example.petya.tinkofffintech.mainmenuactivity.events;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.EventsLocalDataSource;
import com.example.petya.tinkofffintech.util.Utils;

import java.util.Collections;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public class EventsPresenter implements EventsContract.Presenter {

    private final static String KEY = "bf5e348de3daca8f75ad68aef72b58b4b8a44e45fa1adb4f9f69d17b1f58a3ef";

    private final Repository mRepository;

    @Nullable
    private EventsContract.View mEventsView;

    public EventsPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(EventsContract.View view) {
        mEventsView = view;
        swipeRefresh();
    }

    @Override
    public void dropView() {
        mEventsView = null;
    }

    @Override
    public void swipeRefresh() {
        if (mEventsView == null)
            return;
        if(!Utils.isOnline(mRepository.getConnectivityManager())) {
            mEventsView.showNoInternet();
            mEventsView.offSwipeRefresh();
        } else {
            Flowable.concat(mRepository.getEventsLocalDataSource().getEventsLocalData(), getEventsData())
                    .first((EventsData) Collections.emptyList())
                    .subscribe(new SingleObserver<EventsData>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }
                        @Override
                        public void onSuccess(EventsData eventsData) {
                            mEventsView.setAdapter(eventsData);
                            saveDataDb(eventsData.getEvents());
                            mEventsView.offSwipeRefresh();
                        }
                        @Override
                        public void onError(Throwable e) {
                            mEventsView.showError();
                            mEventsView.offSwipeRefresh();
                        }
                    });
                    //getEventsData()

                    /*.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<EventsData>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(EventsData eventsData) {
                            mEventsView.setAdapter(eventsData);
                            saveDataDb(eventsData.getEvents());
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
                    });*/
        }
    }

    private void saveDataDb(Events events) {
        mRepository.getEventsLocalDataSource().insertOrUpdateUser(events);
    }

    private Flowable<EventsData> getEventsData() {
        return Flowable.zip(mRepository.getApiUnsplash().getLinkImage(KEY, "spring"),
                mRepository.getApiServer().getEvents2(),
                new BiFunction<Unsplash, Events, EventsData>() {
                    @Override
                    public EventsData apply(Unsplash unsplash, Events events) throws Exception {
                        return new EventsData(events, unsplash);
                    }
                });
    }
}
