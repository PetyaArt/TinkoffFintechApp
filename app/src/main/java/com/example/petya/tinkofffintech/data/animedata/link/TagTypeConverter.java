package com.example.petya.tinkofffintech.data.animedata.link;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TagTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Tag> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Tag>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToStringTag(List<Tag> someObjects) {
        return gson.toJson(someObjects);
    }


    @TypeConverter
    public static List<PhotoTag> stringToListTag(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<PhotoTag>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<PhotoTag> someObjects) {
        return gson.toJson(someObjects);
    }
}
