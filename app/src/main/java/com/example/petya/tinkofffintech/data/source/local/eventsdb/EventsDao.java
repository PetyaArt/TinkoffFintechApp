package com.example.petya.tinkofffintech.data.source.local.eventsdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

@Dao
public interface EventsDao {

    @Query("SELECT * FROM Events")
    Flowable<Events> getEvents();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Events events);

    @Update
    void update(Events events);

    @Query("DELETE FROM Events")
    void deleteAll();
}
