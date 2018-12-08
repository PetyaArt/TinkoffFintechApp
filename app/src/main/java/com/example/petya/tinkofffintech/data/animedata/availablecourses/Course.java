
package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("is_teacher")
    @Expose
    private Boolean isTeacher;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("pending_tasks")
    @Expose
    private PendingTasks pendingTasks;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("event_date_start")
    @Expose
    private String eventDateStart;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("diploma_url")
    @Expose
    private String diplomaUrl;

    public Boolean getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Boolean isTeacher) {
        this.isTeacher = isTeacher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PendingTasks getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(PendingTasks pendingTasks) {
        this.pendingTasks = pendingTasks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEventDateStart() {
        return eventDateStart;
    }

    public void setEventDateStart(String eventDateStart) {
        this.eventDateStart = eventDateStart;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDiplomaUrl() {
        return diplomaUrl;
    }

    public void setDiplomaUrl(String diplomaUrl) {
        this.diplomaUrl = diplomaUrl;
    }

}
