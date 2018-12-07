package com.example.petya.tinkofffintech.data.animedata.link;

import android.arch.persistence.room.TypeConverter;

import com.example.petya.tinkofffintech.data.animedata.event.Active;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class UnsplashTypeConverter {

    @TypeConverter
    public String fromActiveList(List<Result> resultList) {
        if (resultList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Active>>() {}.getType();
        return gson.toJson(resultList, type);
    }

    @TypeConverter
    public List<Result> toActiveList(String resultList) {
        if (resultList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Active>>() {}.getType();
        return gson.fromJson(resultList, type);
    }
}
