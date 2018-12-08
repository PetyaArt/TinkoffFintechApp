package com.example.petya.tinkofffintech.data.animedata.event;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EventsDataConverter {

    @TypeConverter
    public String fromActiveList(List<Active> activeList) {
        if (activeList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Active>>() {}.getType();
        return gson.toJson(activeList, type);
    }

    @TypeConverter
    public List<Active> toActiveList(String activeList) {
        if (activeList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Active>>() {}.getType();
        return gson.fromJson(activeList, type);
    }


    @TypeConverter
    public String fromArchiveList(List<Archive> archiveList) {
        if (archiveList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Archive>>() {}.getType();
        return gson.toJson(archiveList, type);
    }

    @TypeConverter
    public List<Archive> toArchiveList(String archiveList) {
        if (archiveList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Archive>>() {}.getType();
        return gson.fromJson(archiveList, type);
    }


}
