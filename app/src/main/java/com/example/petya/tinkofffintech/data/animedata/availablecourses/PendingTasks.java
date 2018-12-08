
package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import android.arch.persistence.room.TypeConverters;

import com.example.petya.tinkofffintech.data.animedata.DataTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PendingTasks {

    @TypeConverters(AvailableCoursesTypeConverter.class)
    @SerializedName("lecture_tests")
    @Expose
    private List<LectureTest> lectureTests = null;

    @TypeConverters(DataTypeConverter.class)
    @SerializedName("tasks")
    @Expose
    private List<String> tasks = null;

    public List<LectureTest> getLectureTests() {
        return lectureTests;
    }

    public void setLectureTests(List<LectureTest> lectureTests) {
        this.lectureTests = lectureTests;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

}
