package com.example.petya.tinkofffintech.data.animedata.courses;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class CoursesTypeConverter {

    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Grade> GradeToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Grade>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToGrade(List<Grade> someObjects) {
        return gson.toJson(someObjects);
    }


    @TypeConverter
    public static List<List<GroupedTask>> GroupedTaskToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<List<GroupedTask>>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToGroupedTask(List<List<GroupedTask>> someObjects) {
        return gson.toJson(someObjects);
    }


    @TypeConverter
    public static List<SubGrade> SubGradeToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<SubGrade>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToSubGrade(List<SubGrade> someObjects) {
        return gson.toJson(someObjects);
    }




}
