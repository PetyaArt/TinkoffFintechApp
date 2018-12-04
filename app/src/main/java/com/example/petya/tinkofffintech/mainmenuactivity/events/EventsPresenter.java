package com.example.petya.tinkofffintech.mainmenuactivity.events;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.source.Repository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventsPresenter implements EventsContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private EventsContract.View mEventsView;

    public EventsPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(EventsContract.View view) {
        mEventsView = view;
        mRepository.getApiServer().getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Events>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Events events) {
                        Log.d("myLogs", String.valueOf(events.getActive()));
                        mEventsView.setAdapter(events);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("myLogs", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void dropView() {
        mEventsView = null;
    }
}
