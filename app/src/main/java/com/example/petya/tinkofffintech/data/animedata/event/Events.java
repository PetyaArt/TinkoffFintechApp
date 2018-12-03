
package com.example.petya.tinkofffintech.data.animedata.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {

    @SerializedName("active")
    @Expose
    private List<Active> active = null;
    @SerializedName("archive")
    @Expose
    private List<Archive> archive = null;

    public List<Active> getActive() {
        return active;
    }

    public void setActive(List<Active> active) {
        this.active = active;
    }

    public List<Archive> getArchive() {
        return archive;
    }

    public void setArchive(List<Archive> archive) {
        this.archive = archive;
    }

}
