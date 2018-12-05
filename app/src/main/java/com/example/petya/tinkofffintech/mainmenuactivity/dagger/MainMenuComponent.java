package com.example.petya.tinkofffintech.mainmenuactivity.dagger;

import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.mainmenuactivity.MainMenuActivity;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.mycourses.MyCoursesFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.profile.ProfileFragment;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = MainMenuModule.class)
public interface MainMenuComponent {
    void injectMainMenuActivity(MainMenuActivity mainMenuActivity);
    void injectEventsFragment(EventsFragment eventsFragment);
    void injectMyCoursesFragment(MyCoursesFragment myCoursesFragment);
    void injectProfileFragment(ProfileFragment profileFragment);
}
