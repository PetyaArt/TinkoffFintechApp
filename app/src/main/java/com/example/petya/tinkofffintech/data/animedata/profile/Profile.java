
package com.example.petya.tinkofffintech.data.animedata.profile;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "profile")
public class Profile {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @SerializedName("user")
    @Expose
    @Embedded
    private User user;

    @SerializedName("status")
    @Expose
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
