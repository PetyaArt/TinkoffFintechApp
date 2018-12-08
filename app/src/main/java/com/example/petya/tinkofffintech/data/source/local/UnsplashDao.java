package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;

import io.reactivex.Maybe;

@Dao
public interface UnsplashDao {

    @Query("SELECT * FROM Unsplash")
    Maybe<Unsplash> getUnsplash();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Unsplash unsplash);

    @Update
    void update(Unsplash events);

    @Query("DELETE FROM Unsplash")
    void deleteAll();
}
