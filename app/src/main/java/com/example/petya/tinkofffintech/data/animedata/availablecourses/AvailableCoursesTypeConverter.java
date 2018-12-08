package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class AvailableCoursesTypeConverter {

    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Archive> archiveToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Archive>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToArchive(List<Archive> someObjects) {
        return gson.toJson(someObjects);
    }


    @TypeConverter
    public static List<Course> courseToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Course>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToCourse(List<Course> someObjects) {
        return gson.toJson(someObjects);
    }


    @TypeConverter
    public static List<LectureTest> lectureTestToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<LectureTest>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToLectureTest(List<LectureTest> someObjects) {
        return gson.toJson(someObjects);
    }


}
