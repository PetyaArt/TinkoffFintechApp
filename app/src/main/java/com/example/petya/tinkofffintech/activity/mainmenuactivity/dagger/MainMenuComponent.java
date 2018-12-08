package com.example.petya.tinkofffintech.activity.mainmenuactivity.dagger;

import com.example.petya.tinkofffintech.activity.mainmenuactivity.MainMenuActivity;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.events.EventsFragment;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses.MyCoursesFragment;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.profile.ProfileFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = MainMenuModule.class)
public interface MainMenuComponent {
    void injectMainMenuActivity(MainMenuActivity mainMenuActivity);
    void injectEventsFragment(EventsFragment eventsFragment);
    void injectMyCoursesFragment(MyCoursesFragment myCoursesFragment);
    void injectProfileFragment(ProfileFragment profileFragment);
}
