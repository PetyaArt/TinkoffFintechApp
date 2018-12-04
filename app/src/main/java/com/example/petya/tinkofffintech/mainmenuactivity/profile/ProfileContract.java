package com.example.petya.tinkofffintech.mainmenuactivity.profile;

import com.example.petya.tinkofffintech.BasePresenter;
import com.example.petya.tinkofffintech.BaseView;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

public interface ProfileContract {

    interface View extends BaseView<Presenter> {

        void showProgress();

        void hideProgress();

        void showNoInternet();

        void showError();

        void showData(Profile profile);
    }

    interface Presenter extends BasePresenter<View> {

        void getData();
    }
}
