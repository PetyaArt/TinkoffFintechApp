
package com.example.petya.tinkofffintech.data.animedata.courses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grade {

    @SerializedName("student")
    @Expose
    private String student;

    @SerializedName("student_id")
    @Expose
    private Integer studentId;

    @SerializedName("grades")
    @Expose
    private List<Grade_> grades = null;

    @SerializedName("group_id")
    @Expose
    private Integer groupId;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public List<Grade_> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade_> grades) {
        this.grades = grades;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

}