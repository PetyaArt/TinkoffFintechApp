
package com.example.petya.tinkofffintech.data.animedata.courses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

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
