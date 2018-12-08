
package com.example.petya.tinkofffintech.data.animedata.availablecourses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContestStatus {

    @SerializedName("time_left")
    @Expose
    private String timeLeft;
    @SerializedName("status")
    @Expose
    private String status;

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
