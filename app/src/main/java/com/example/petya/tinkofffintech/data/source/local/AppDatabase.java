package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

@Database(entities = {Profile.class, Events.class, Unsplash.class, Courses.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfileDao profileDao();
    public abstract EventsDao eventsDao();
    public abstract UnsplashDao unsplashDao();
    public abstract CoursesDao coursesDao();
}
