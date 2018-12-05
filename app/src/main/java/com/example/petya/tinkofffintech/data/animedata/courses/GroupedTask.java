
package com.example.petya.tinkofffintech.data.animedata.courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupedTask {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("short_name")
    @Expose
    private String shortName;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("max_score")
    @Expose
    private Integer maxScore;

    @SerializedName("contest__status")
    @Expose
    private Object contestStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Object getContestStatus() {
        return contestStatus;
    }

    public void setContestStatus(Object contestStatus) {
        this.contestStatus = contestStatus;
    }

}
