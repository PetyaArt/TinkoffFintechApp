package com.example.petya.tinkofffintech.mainmenuactivity.profile;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        getData();
    }

    @Override
    public void dropView() {
        mEventsView = null;
    }

    @Override
    public void getData() {
        if (mEventsView == null)
            return;
        mRepository.getApiServer().getProfileInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Profile>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Profile profile) {
                        if (profile.getStatus().equals("Error")) {
                            Log.d("myLogs", profile.getStatus());
                        } else {
                            mEventsView.showData(profile);
                        }
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
}
