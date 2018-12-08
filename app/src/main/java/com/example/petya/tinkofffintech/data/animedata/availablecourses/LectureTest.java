
package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LectureTest {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("contest_status")
    @Expose
    private ContestStatus contestStatus;
    @SerializedName("contest_url")
    @Expose
    private String contestUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ContestStatus getContestStatus() {
        return contestStatus;
    }

    public void setContestStatus(ContestStatus contestStatus) {
        this.contestStatus = contestStatus;
    }

    public String getContestUrl() {
        return contestUrl;
    }

    public void setContestUrl(String contestUrl) {
        this.contestUrl = contestUrl;
    }

}
