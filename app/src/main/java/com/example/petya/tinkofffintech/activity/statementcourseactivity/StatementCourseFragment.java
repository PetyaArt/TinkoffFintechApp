package com.example.petya.tinkofffintech.activity.statementcourseactivity;

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
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.courses.GroupedTask;
import com.example.petya.tinkofffintech.di.App;

import java.util.List;

import javax.inject.Inject;

public class StatementCourseFragment extends Fragment implements StatementCourseContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    StatementCourseContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private int mStudentId;

    @Inject
    public StatementCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getStatementCourseComponent().injectStatementCourseFragment(this);
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
        if (getArguments() != null) {
            mStudentId = getArguments().getInt("STUDENT_ID");
        }
        return inflater.inflate(R.layout.fragment_statement_course, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerViewStatementCourse);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSwipeRefreshLayout = view.findViewById(R.id.swiperefreshStatementCourse);
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
    public void showData(Courses courses, List<GroupedTask> list) {
        Grade grade = null;
        for (Grade g: courses.getGrades()) {
            if (g.getStudentId() == mStudentId) {
                grade = g;
            }
        }
        if (grade == null)
            return;

        StatementCourseViewAdapter relevantViewAdapter = new StatementCourseViewAdapter(list, grade);
        mRecyclerView.setAdapter(relevantViewAdapter);
    }

    @Override
    public void onRefresh() {
        mPresenter.swipeSync();
    }
}
