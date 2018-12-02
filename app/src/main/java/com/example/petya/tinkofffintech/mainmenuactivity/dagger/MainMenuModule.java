package com.example.petya.tinkofffintech.mainmenuactivity.dagger;

import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.mycourses.MyCoursesFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.profile.ProfileFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class MainMenuModule {

    @ActivityScoped
    @Provides
    EventsFragment eventsFragment() {
        return new EventsFragment();
    }

    @ActivityScoped
    @Provides
    MyCoursesFragment myCoursesFragment() {
        return new MyCoursesFragment();
    }

    @ActivityScoped
    @Provides
    ProfileFragment profileFragment() {
        return new ProfileFragment();
    }
}
