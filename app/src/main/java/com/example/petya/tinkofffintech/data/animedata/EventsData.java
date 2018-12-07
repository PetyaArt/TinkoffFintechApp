package com.example.petya.tinkofffintech.data.animedata;

import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.data.animedata.link.Unsplash;

public class EventsData {
    private Events mEvents;
    private Unsplash mUnsplash;

    public EventsData(Events events, Unsplash unsplash) {
        mEvents = events;
        mUnsplash = unsplash;
    }

    public Events getEvents() {
        return mEvents;
    }

    public Unsplash getUnsplash() {
        return mUnsplash;
    }
}
