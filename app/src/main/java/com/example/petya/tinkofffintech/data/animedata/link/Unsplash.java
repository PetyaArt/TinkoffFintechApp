
package com.example.petya.tinkofffintech.data.animedata.link;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@TypeConverters(UnsplashTypeConverter.class)
@Entity(tableName = "unsplash")
public class Unsplash {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
