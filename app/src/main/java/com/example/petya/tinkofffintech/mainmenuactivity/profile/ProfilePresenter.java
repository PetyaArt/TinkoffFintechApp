package com.example.petya.tinkofffintech.mainmenuactivity.profile;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsContract;

public class ProfilePresenter implements ProfileContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private ProfileContract.View mEventsView;

    public ProfilePresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(ProfileContract.View view) {
        mEventsView = view;
    }

    @Override
    public void dropView() {
        mEventsView = null;
    }
}
