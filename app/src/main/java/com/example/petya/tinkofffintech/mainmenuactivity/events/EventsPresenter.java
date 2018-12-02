package com.example.petya.tinkofffintech.mainmenuactivity.events;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.authactivity.AuthContract;
import com.example.petya.tinkofffintech.data.source.Repository;

import javax.inject.Inject;

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
    }

    @Override
    public void dropView() {
        mEventsView = null;
    }
}
