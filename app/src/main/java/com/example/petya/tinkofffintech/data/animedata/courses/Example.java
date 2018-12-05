
package com.example.petya.tinkofffintech.data.animedata.courses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("grouped_tasks")
    @Expose
    private List<List<GroupedTask>> groupedTasks = null;

    @SerializedName("grades")
    @Expose
    private List<Grade> grades = null;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("mentor")
    @Expose
    private Object mentor;

    @SerializedName("mentor_id")
    @Expose
    private Object mentorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Object getMentor() {
        return mentor;
    }

    public void setMentor(Object mentor) {
        this.mentor = mentor;
    }

    public Object getMentorId() {
        return mentorId;
    }

    public void setMentorId(Object mentorId) {
        this.mentorId = mentorId;
    }

}
