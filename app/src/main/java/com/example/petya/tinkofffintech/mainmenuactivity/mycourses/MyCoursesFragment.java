package com.example.petya.tinkofffintech.mainmenuactivity.mycourses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;

public class MyCoursesFragment extends Fragment {

    public MyCoursesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getMainMenuComponent().injectMyCoursesFragment(this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            Toolbar toolbar = view.findViewById(R.id.toolbarCourses);
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        }
    }
}
