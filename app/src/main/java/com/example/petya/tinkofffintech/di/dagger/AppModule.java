package com.example.petya.tinkofffintech.di.dagger;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.petya.tinkofffintech.data.source.local.AppDatabase;
import com.example.petya.tinkofffintech.data.source.local.ProfileDao;
import com.example.petya.tinkofffintech.network.ApiServer;
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

    @Singleton
    @Provides
    ApiServer getApiServer() {
        return new RetrofitInstance(context).getApiServer();
    }
}
