package com.example.petya.tinkofffintech.data.animedata;

import com.example.petya.tinkofffintech.data.animedata.availablecourses.AvailableCourses;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

public class ProfileData {

    private final AvailableCourses mAvailableCourses;
    private final Profile mProfile;

    public ProfileData(AvailableCourses availableCourses, Profile profile) {
        mAvailableCourses = availableCourses;
        mProfile = profile;
    }

    public AvailableCourses getAvailableCourses() {
        return mAvailableCourses;
    }

    public Profile getProfile() {
        return mProfile;
    }
}
