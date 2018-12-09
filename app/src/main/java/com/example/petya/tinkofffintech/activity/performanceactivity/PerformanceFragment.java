package com.example.petya.tinkofffintech.activity.performanceactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseActivity;
import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class PerformanceFragment extends Fragment implements PerformanceContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    PerformanceContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    public PerformanceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getPerformanceActivityComponent().injectPerformanceFragment(this);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_performance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerViewPerformance);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSwipeRefreshLayout = view.findViewById(R.id.swiperefreshPerformance);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void offSwipeRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showNoInternet() {
        showMessage(getString(R.string.no_internet));
    }

    @Override
    public void showError() {
        showMessage(getString(R.string.error));
    }

    private void showMessage(String message) {
        if (getActivity() != null) {
            Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showData(Courses courses) {
        PerformanceViewAdapter relevantViewAdapter = new PerformanceViewAdapter(new PerformanceViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Grade grade) {
                Intent intent = new Intent(getActivity(), StatementCourseActivity.class);
                intent.putExtra("STUDENT_ID", grade.getStudentId());
                startActivity(intent);
            }
        });
        relevantViewAdapter.setEvents(courses);
        mRecyclerView.setAdapter(relevantViewAdapter);
    }

    @Override
    public void onRefresh() {
        mPresenter.swipeSync();
    }
}
