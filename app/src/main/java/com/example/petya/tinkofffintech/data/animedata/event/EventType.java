
package com.example.petya.tinkofffintech.data.animedata.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventType {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("color")
    @Expose
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
