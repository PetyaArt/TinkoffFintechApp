
package com.example.petya.tinkofffintech.data.animedata.event;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@TypeConverters(EventsDataConverter.class)
@Entity(tableName = "events")
public class Events {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("active")
    @Expose
    private List<Active> active = null;

    @SerializedName("archive")
    @Expose
    private List<Archive> archive = null;

    public List<Active> getActive() {
        return active;
    }

    public void setActive(List<Active> active) {
        this.active = active;
    }

    public List<Archive> getArchive() {
        return archive;
    }

    public void setArchive(List<Archive> archive) {
        this.archive = archive;
    }

}
