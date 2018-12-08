
package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Archive {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("event_participation_type")
    @Expose
    private String eventParticipationType;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("event_date_start")
    @Expose
    private String eventDateStart;
    @SerializedName("event_date_end")
    @Expose
    private String eventDateEnd;
    @SerializedName("event_type")
    @Expose
    private String eventType;
    @SerializedName("event_url")
    @Expose
    private String eventUrl;
    @SerializedName("event_status")
    @Expose
    private String eventStatus;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("info_url")
    @Expose
    private String infoUrl;
    @SerializedName("exams_status")
    @Expose
    private String examsStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventParticipationType() {
        return eventParticipationType;
    }

    public void setEventParticipationType(String eventParticipationType) {
        this.eventParticipationType = eventParticipationType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDateStart() {
        return eventDateStart;
    }

    public void setEventDateStart(String eventDateStart) {
        this.eventDateStart = eventDateStart;
    }

    public String getEventDateEnd() {
        return eventDateEnd;
    }

    public void setEventDateEnd(String eventDateEnd) {
        this.eventDateEnd = eventDateEnd;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public String getExamsStatus() {
        return examsStatus;
    }

    public void setExamsStatus(String examsStatus) {
        this.examsStatus = examsStatus;
    }

}
