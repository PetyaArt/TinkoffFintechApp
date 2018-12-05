
package com.example.petya.tinkofffintech.data.animedata.courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubGrade {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("mark")
    @Expose
    private Float mark;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("task_type")
    @Expose
    private String taskType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

}
