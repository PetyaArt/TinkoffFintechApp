package com.example.petya.tinkofffintech.mainmenuactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.mainmenuactivity.events.EventsFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.mycourses.MyCoursesFragment;
import com.example.petya.tinkofffintech.mainmenuactivity.profile.ProfileFragment;

import javax.inject.Inject;

public class MainMenuActivity extends AppCompatActivity {

    @Inject
    EventsFragment mEventsFragment;
    @Inject
    MyCoursesFragment mMyCoursesFragment;
    @Inject
    ProfileFragment mProfileFragment;

    Fragment mFragmentActive;

    final FragmentManager fm = getSupportFragmentManager();
    //TODO: добавить swipe to refresh
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_events:
                    fm.beginTransaction().hide(mFragmentActive).show(mEventsFragment).commit();
                    mFragmentActive = mEventsFragment;
                    return true;
                case R.id.navigation_school:
                    fm.beginTransaction().hide(mFragmentActive).show(mMyCoursesFragment).commit();
                    mFragmentActive = mMyCoursesFragment;
                    return true;
                case R.id.navigation_profile:
                    fm.beginTransaction().hide(mFragmentActive).show(mProfileFragment).commit();
                    mFragmentActive = mProfileFragment;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        App.getApp(this).getComponentsHolder().getMainMenuComponent().injectMainMenuActivity(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //TODO:баг при перевороте экрана фрагменты накладываються
        mFragmentActive = mEventsFragment;
        fm.beginTransaction().add(R.id.main_container, mProfileFragment, "3").hide(mProfileFragment).commit();
        fm.beginTransaction().add(R.id.main_container, mMyCoursesFragment, "2").hide(mMyCoursesFragment).commit();
        fm.beginTransaction().add(R.id.main_container,mEventsFragment, "1").commit();
    }
}
