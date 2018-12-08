package com.example.petya.tinkofffintech.activity.mainmenuactivity.profile;

import android.support.annotation.Nullable;

import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.util.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProfilePresenter implements ProfileContract.Presenter {

    private final Repository mRepository;

    @Nullable
    private ProfileContract.View mProfileView;

    public ProfilePresenter(Repository repository) {
        mRepository = repository;
    }

    @Override
    public void takeView(ProfileContract.View view) {
        mProfileView = view;
        swipeSync();
    }

    @Override
    public void dropView() {
        mProfileView = null;
    }

    @Override
    public void swipeSync() {
        if (mProfileView == null)
            return;

        mProfileView.showProgress();

        if (!Utils.isOnline(mRepository.getConnectivityManager())) {
            mProfileView.showNoInternet();
        }

        mRepository.getApiServer().getProfileInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Profile>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Profile profile) {
                        mProfileView.showData(profile);
                        mProfileView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mProfileView.showError();
                        mProfileView.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        mProfileView.hideProgress();
                    }
                });

        mRepository.getApiServer().getCource()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonArray>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonArray jsonArray) {
                        Courses courses = new Gson().fromJson(jsonArray.get(1), Courses.class);
                        mProfileView.setAdapter(courses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mProfileView.showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void signOut() {
        if (mProfileView == null)
            return;
        mRepository.getApiServer().signOut()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Response<Void>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<Void> voidResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mProfileView.showError();
                    }
                });
    }
}
