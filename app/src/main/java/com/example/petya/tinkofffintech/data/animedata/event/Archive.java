
package com.example.petya.tinkofffintech.data.animedata.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Archive {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("date_start")
    @Expose
    private String dateStart;

    @SerializedName("date_end")
    @Expose
    private String dateEnd;

    @SerializedName("event_type")
    @Expose
    private EventType eventType;

    @SerializedName("custom_date")
    @Expose
    private String customDate;

    @SerializedName("place")
    @Expose
    private String place;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("url_external")
    @Expose
    private Boolean urlExternal;

    @SerializedName("display_button")
    @Expose
    private Boolean displayButton;

    @SerializedName("url_text")
    @Expose
    private String urlText;

    @SerializedName("description")
    @Expose
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getCustomDate() {
        return customDate;
    }

    public void setCustomDate(String customDate) {
        this.customDate = customDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getUrlExternal() {
        return urlExternal;
    }

    public void setUrlExternal(Boolean urlExternal) {
        this.urlExternal = urlExternal;
    }

    public Boolean getDisplayButton() {
        return displayButton;
    }

    public void setDisplayButton(Boolean displayButton) {
        this.displayButton = displayButton;
    }

    public String getUrlText() {
        return urlText;
    }

    public void setUrlText(String urlText) {
        this.urlText = urlText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
