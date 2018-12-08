package com.example.petya.tinkofffintech.data.animedata;

import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;

public class CoursesData {

    private Profile mProfile;
    private Courses mCourses;

    public CoursesData(Profile profile, Courses courses) {
        mProfile = profile;
        mCourses = courses;
    }

    public Profile getProfile() {
        return mProfile;
    }

    public Courses getCourses() {
        return mCourses;
    }
}
