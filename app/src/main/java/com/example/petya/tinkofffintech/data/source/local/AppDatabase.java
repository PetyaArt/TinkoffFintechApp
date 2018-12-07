package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.EventsDao;
import com.example.petya.tinkofffintech.data.source.local.eventsdb.UnsplashDao;

@Database(entities = {Profile.class, Events.class, Unsplash.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfileDao profileDao();
    public abstract EventsDao eventsDao();
    public abstract UnsplashDao UnsplashDao();
}
