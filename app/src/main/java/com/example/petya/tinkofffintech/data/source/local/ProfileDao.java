package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

import io.reactivex.Maybe;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM Profile")
    Maybe<Profile> getProfile();

    @Insert
    void insert(Profile profile);

    @Update
    void update(Profile profile);

    @Query("DELETE FROM Profile")
    void deleteAll();
}
