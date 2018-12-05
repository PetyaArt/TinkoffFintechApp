package com.example.petya.tinkofffintech.mainmenuactivity.mycourses;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.courses.Example;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class MyCoursesFragment extends Fragment implements MyCoursesContract.View {

    @Inject
    MyCoursesContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    @Inject
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
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerViewMyCourses);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        if (getActivity() != null) {
            Toolbar toolbar = view.findViewById(R.id.toolbarCourses);
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showNoInternet() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showData(Example example) {
        AcademicPerformanceViewAdapter adapter = new AcademicPerformanceViewAdapter();
        adapter.setEvents(example);
        mRecyclerView.setAdapter(adapter);
    }
}
