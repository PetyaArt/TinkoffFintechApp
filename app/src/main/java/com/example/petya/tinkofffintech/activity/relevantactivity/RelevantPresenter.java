package com.example.petya.tinkofffintech.activity.relevantactivity;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

import static com.example.petya.tinkofffintech.activity.mainmenuactivity.events.EventsPresenter.KEY;

public class RelevantPresenter implements RelevantContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private RelevantContract.View mRelevantView;

    @Inject
    public RelevantPresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(RelevantContract.View view) {
        this.mRelevantView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mRelevantView = null;
    }

    @Override
    public void swipeSync() {
        if (mRelevantView == null)
            return;
        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mRelevantView.showNoInternet();
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
                        mRelevantView.setAdapter(eventsData);
                        mRelevantView.offSwipeRefresh();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mRelevantView.showError();
                        mRelevantView.offSwipeRefresh();
                    }

                    @Override
                    public void onComplete() {
                        mRelevantView.offSwipeRefresh();
                    }
                });

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
