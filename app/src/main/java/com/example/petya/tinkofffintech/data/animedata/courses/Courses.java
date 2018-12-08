
package com.example.petya.tinkofffintech.data.animedata.courses;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@TypeConverters(CoursesTypeConverter.class)
@Entity(tableName = "courses")
public class Courses {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("grades")
    @Expose
    private List<Grade> grades = null;

    @SerializedName("grouped_tasks")
    @Expose
    private List<List<GroupedTask>> groupedTasks = null;

    @SerializedName("name")
    @Expose
    private String name;

    public List<List<GroupedTask>> getGroupedTasks() {
        return groupedTasks;
    }

    public void setGroupedTasks(List<List<GroupedTask>> groupedTasks) {
        this.groupedTasks = groupedTasks;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
