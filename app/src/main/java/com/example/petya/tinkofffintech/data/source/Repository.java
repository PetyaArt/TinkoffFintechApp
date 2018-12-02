package com.example.petya.tinkofffintech.data.source;

import com.example.petya.tinkofffintech.data.source.local.ProfileDao;
import com.example.petya.tinkofffintech.network.ApiServer;

import javax.inject.Inject;

public class Repository {

    private final ApiServer mApiServer;

    private final ProfileDao mProfileDao;

    @Inject
    public Repository(ApiServer apiServer, ProfileDao profileDao) {
        mApiServer = apiServer;
        mProfileDao = profileDao;
    }

    public ApiServer getApiServer() {
        return mApiServer;
    }

    public ProfileDao getProfileDao() {
        return mProfileDao;
    }
}
