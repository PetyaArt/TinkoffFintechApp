package com.example.petya.tinkofffintech.data.source;

import android.net.ConnectivityManager;

import com.example.petya.tinkofffintech.data.source.local.eventsdb.EventsDao;
import com.example.petya.tinkofffintech.data.source.local.ProfileDao;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.EventsLocalDataSource;
import com.example.petya.tinkofffintech.network.ApiServer;
import com.example.petya.tinkofffintech.network.ApiUnsplash;

import javax.inject.Inject;

public class Repository {

    private final ApiServer mApiServer;
    private final ApiUnsplash mApiUnsplash;

    private final ConnectivityManager mConnectivityManager;

    private final ProfileDao mProfileDao;
    private final EventsDao mEventsDao;

    private final EventsLocalDataSource mEventsLocalDataSource;

    @Inject
    public Repository(ApiServer apiServer,
                      ApiUnsplash apiUnsplash,
                      ConnectivityManager connectivityManager,
                      ProfileDao profileDao,
                      EventsDao eventsDao,
                      EventsLocalDataSource eventsLocalDataSource) {
        mApiServer = apiServer;
        mApiUnsplash = apiUnsplash;
        mConnectivityManager = connectivityManager;
        mProfileDao = profileDao;
        mEventsDao = eventsDao;
        mEventsLocalDataSource = eventsLocalDataSource;
    }

    public ApiServer getApiServer() {
        return mApiServer;
    }

    public ProfileDao getProfileDao() {
        return mProfileDao;
    }

    public ApiUnsplash getApiUnsplash() {
        return mApiUnsplash;
    }

    public ConnectivityManager getConnectivityManager() {
        return mConnectivityManager;
    }

    public EventsDao getEventsDao() {
        return mEventsDao;
    }

    public EventsLocalDataSource getEventsLocalDataSource() {
        return mEventsLocalDataSource;
    }
}
