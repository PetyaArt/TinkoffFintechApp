package com.example.petya.tinkofffintech.activity.mainmenuactivity.dagger;

import com.example.petya.tinkofffintech.activity.mainmenuactivity.events.EventsContract;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.events.EventsFragment;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.events.EventsPresenter;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses.MyCoursesContract;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses.MyCoursesFragment;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses.MyCoursesPresenter;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.profile.ProfileContract;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.profile.ProfileFragment;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.profile.ProfilePresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

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

    @ActivityScoped
    @Provides
    EventsContract.Presenter eventsPresenter(Repository repository) {
        return new EventsPresenter(repository);
    }

    @ActivityScoped
    @Provides
    ProfileContract.Presenter profilePresenter(Repository repository) {
        return new ProfilePresenter(repository);
    }

    @ActivityScoped
    @Provides
    MyCoursesContract.Presenter myCoursesPresenter(Repository repository) {
        return new MyCoursesPresenter(repository);
    }
}
