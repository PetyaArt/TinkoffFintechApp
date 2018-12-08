
package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import android.arch.persistence.room.TypeConverters;

import com.example.petya.tinkofffintech.data.animedata.DataTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AvailableCourses {

    @TypeConverters(DataTypeConverter.class)
    @SerializedName("active")
    @Expose
    private List<String> active = null;

    @TypeConverters(AvailableCoursesTypeConverter.class)
    @SerializedName("archive")
    @Expose
    private List<Archive> archive = null;

    @TypeConverters(AvailableCoursesTypeConverter.class)
    @SerializedName("courses")
    @Expose
    private List<Course> courses = null;

    public List<String> getActive() {
        return active;
    }

    public void setActive(List<String> active) {
        this.active = active;
    }

    public List<Archive> getArchive() {
        return archive;
    }

    public void setArchive(List<Archive> archive) {
        this.archive = archive;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
