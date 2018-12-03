package com.example.petya.tinkofffintech.pastactivity;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.source.Repository;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PastPresenter implements PastContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private PastContract.View mAuthView;

    @Inject
    public PastPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(PastContract.View view) {
        this.mAuthView = view;
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
                        mAuthView.setAdapter(events);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void dropView() {
        mAuthView = null;
    }

}
