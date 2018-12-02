package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

@Database(entities = {Profile.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfileDao profileDao();
}
