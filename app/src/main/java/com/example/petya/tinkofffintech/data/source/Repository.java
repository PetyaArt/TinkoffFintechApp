package com.example.petya.tinkofffintech.data.source;

import android.net.ConnectivityManager;

import com.example.petya.tinkofffintech.data.source.local.CoursesDao;
import com.example.petya.tinkofffintech.data.source.local.CoursesLocalDataSource;
import com.example.petya.tinkofffintech.data.source.local.EventsDao;
import com.example.petya.tinkofffintech.data.source.local.EventsLocalDataSource;
import com.example.petya.tinkofffintech.data.source.local.ProfileDao;
import com.example.petya.tinkofffintech.network.ApiServer;
import com.example.petya.tinkofffintech.network.ApiUnsplash;

import javax.inject.Inject;

public class Repository {

    private final ApiServer mApiServer;
    private final ApiUnsplash mApiUnsplash;

    private final ConnectivityManager mConnectivityManager;

    private final ProfileDao mProfileDao;
    private final EventsDao mEventsDao;
    private final CoursesDao mCoursesDao;

    private final EventsLocalDataSource mEventsLocalDataSource;
    private final CoursesLocalDataSource mCoursesLocalDataSource;

    @Inject
    public Repository(ApiServer apiServer,
                      ApiUnsplash apiUnsplash,
                      ConnectivityManager connectivityManager,
                      ProfileDao profileDao,
                      EventsDao eventsDao,
                      EventsLocalDataSource eventsLocalDataSource,
                      CoursesDao coursesDao,
                      CoursesLocalDataSource coursesLocalDataSource) {
        mApiServer = apiServer;
        mApiUnsplash = apiUnsplash;
        mConnectivityManager = connectivityManager;
        mProfileDao = profileDao;
        mEventsDao = eventsDao;
        mEventsLocalDataSource = eventsLocalDataSource;
        mCoursesDao = coursesDao;
        mCoursesLocalDataSource = coursesLocalDataSource;
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

    public CoursesDao getCoursesDao() {
        return mCoursesDao;
    }

    public CoursesLocalDataSource getCoursesLocalDataSource() {
        return mCoursesLocalDataSource;
    }
}
