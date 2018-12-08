package com.example.petya.tinkofffintech.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.petya.tinkofffintech.data.animedata.courses.Courses;

import io.reactivex.Maybe;

@Dao
public interface CoursesDao {

    @Query("SELECT * FROM courses")
    Maybe<Courses> getCourses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Courses courses);

    @Update
    void update(Courses courses);

    @Query("DELETE FROM Courses")
    void deleteAll();
}
