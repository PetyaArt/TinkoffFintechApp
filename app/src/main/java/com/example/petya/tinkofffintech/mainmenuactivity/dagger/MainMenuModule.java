package com.example.petya.tinkofffintech.mainmenuactivity.dagger;

import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;
import com.example.petya.tinkofffintech.di.dagger.FragmentScoped;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsContract;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsPresenter;
import com.example.petya.tinkofffintech.mainmenuactivity.mycourses.MyCoursesContract;
import com.example.petya.tinkofffintech.mainmenuactivity.mycourses.MyCoursesFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.mycourses.MyCoursesPresenter;
import com.example.petya.tinkofffintech.mainmenuactivity.profile.ProfileContract;
import com.example.petya.tinkofffintech.mainmenuactivity.profile.ProfileFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.profile.ProfilePresenter;

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
