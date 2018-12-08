package com.example.petya.tinkofffintech.activity.pastactivity;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PastPresenter implements PastContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private PastContract.View mPastView;

    @Inject
    public PastPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(PastContract.View view) {
        this.mPastView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mPastView = null;
    }

    @Override
    public void swipeSync() {
        if (mPastView == null)
            return;
        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mPastView.showNoInternet();
        }
        Maybe.concat(mRepository.getEventsDao().getEvents(), mRepository.getApiServer().getEvents())
                .firstElement()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Events>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Events events) {
                        mPastView.setAdapter(events);
                        mPastView.offSwipeRefresh();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mPastView.showError();
                        mPastView.offSwipeRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mPastView.offSwipeRefresh();
                    }
                });
    }

}
