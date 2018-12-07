package com.example.petya.tinkofffintech.di.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.ConnectivityManager;

import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.source.local.AppDatabase;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.EventsDao;
import com.example.petya.tinkofffintech.data.source.local.ProfileDao;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.EventsLocalDataSource;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.UnsplashDao;
import com.example.petya.tinkofffintech.network.AddCookieInterceptor;
import com.example.petya.tinkofffintech.network.ApiServer;
import com.example.petya.tinkofffintech.network.ApiUnsplash;
import com.example.petya.tinkofffintech.network.ReceivedCookiesInterceptor;
import com.example.petya.tinkofffintech.network.RetrofitInstance;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    AppDatabase provideDb() {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "main.db")
                .build();
    }

    @Singleton
    @Provides
    ProfileDao profileDao(AppDatabase db) {
        return db.profileDao();
    }

    @Provides
    @Singleton
    EventsDao eventsDao(AppDatabase db) {
        return db.eventsDao();
    }

    @Provides
    @Singleton
    UnsplashDao unsplashDao(AppDatabase db) {
        return db.UnsplashDao();
    }

    @Provides
    @Singleton
    EventsLocalDataSource eventsLocalDataSource(EventsDao eventsDao, UnsplashDao unsplashDao) {
        return new EventsLocalDataSource(eventsDao, unsplashDao);
    }

    @Singleton
    @Provides
    ApiServer getApiServer() {
        return new RetrofitInstance(getAddCookieInterceptor(), getReceivedCookiesInterceptor()).getApiServer( );
    }

    @Singleton
    @Provides
    ApiUnsplash getApiUnsplash() {
        return new RetrofitInstance().getApiUnsplash();
    }

    @Provides
    @Singleton
    ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    @Singleton
    AddCookieInterceptor getAddCookieInterceptor() {
        return new AddCookieInterceptor(context);
    }

    @Provides
    @Singleton
    ReceivedCookiesInterceptor getReceivedCookiesInterceptor() {
        return new ReceivedCookiesInterceptor(context);
    }
}
