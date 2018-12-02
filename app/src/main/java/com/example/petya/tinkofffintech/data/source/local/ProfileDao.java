package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM Profile")
    Profile getProfile();

    @Insert
    void insert(Profile profile);

    @Update
    void update(Profile profile);

    @Delete
    void delete(Profile profile);
}
