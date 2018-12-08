package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.petya.tinkofffintech.data.animedata.event.Events;

import io.reactivex.Maybe;

@Dao
public interface EventsDao {

    @Query("SELECT * FROM Events")
    Maybe<Events> getEvents();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Events events);

    @Update
    void update(Events events);

    @Query("DELETE FROM Events")
    void deleteAll();
}
