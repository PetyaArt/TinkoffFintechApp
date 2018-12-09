package com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.MainMenuActivity;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceActivity;
import com.example.petya.tinkofffintech.activity.performanceactivity.PerformanceViewAdapter;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseActivity;
import com.example.petya.tinkofffintech.data.animedata.availablecourses.AvailableCourses;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.courses.SubGrade;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.di.App;
import com.txusballesteros.widgets.FitChart;

import javax.inject.Inject;

public class MyCoursesFragment extends Fragment implements MyCoursesContract.View, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    MyCoursesContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerViewAvailable;

    private FitChart mFitChatPoints;
    private TextView mTextViewSpecificPerformance;

    private TextView mTextViewSpecificRating;
    private TextView mTextViewPointsOverallRating;
    private TextView mTextViewPointsPassTest;
    private TextView mTextViewPointsDoneHomework;

    private TextView mTextViewFitChatPoints;
    private ProgressBar mProgressBarLesson;
    private TextView mTextViewCounterLessonNumber;
    private TextView mTextViewCounterPassedLessonNumber;
    private TextView mTextViewCounterRemainedLessonNumber;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private float points = 0f;

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
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            Toolbar toolbar = view.findViewById(R.id.toolbarCourses);
            toolbar.setTitle(R.string.my_course);
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        }

        mRecyclerView = view.findViewById(R.id.recyclerViewMyCourses);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        mRecyclerViewAvailable = view.findViewById(R.id.recyclerViewAvailableCourses);
        mRecyclerViewAvailable.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        mFitChatPoints = view.findViewById(R.id.fitChatPoints);
        mTextViewSpecificPerformance = view.findViewById(R.id.textViewSpecificPerformance);
        mTextViewSpecificRating = view.findViewById(R.id.textViewSpecificRating);
        mTextViewSpecificPerformance.setOnClickListener(this);
        mTextViewSpecificRating.setOnClickListener(this);

        mTextViewPointsOverallRating = view.findViewById(R.id.textViewPointsOverallRating);
        mTextViewPointsPassTest = view.findViewById(R.id.textViewPointsPassTest);
        mTextViewPointsDoneHomework = view.findViewById(R.id.textViewPointsDoneHomework);

        mTextViewCounterPassedLessonNumber = view.findViewById(R.id.textViewCounterPassedLessonNumber);
        mTextViewCounterRemainedLessonNumber = view.findViewById(R.id.textViewCounterRemainedLessonNumber);

        mFitChatPoints = view.findViewById(R.id.fitChatPoints);
        mTextViewFitChatPoints = view.findViewById(R.id.textViewFitChatPoints);

        mProgressBarLesson = view.findViewById(R.id.progressBarLesson);
        mTextViewCounterLessonNumber = view.findViewById(R.id.textViewCounterLessonNumber);

        mSwipeRefreshLayout = view.findViewById(R.id.swiperefreshMyCourses);
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
        Grade grade = null;
        for (Grade g: courses.getGrades()) {
            if (g.getStudentId() == 5350) {
                grade = g;
            }
        }
        if (grade == null)
            return;

        AcademicPerformanceViewAdapter adapter = new AcademicPerformanceViewAdapter(new AcademicPerformanceViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Grade grade) {
                Intent intent = new Intent(getActivity(), StatementCourseActivity.class);
                intent.putExtra("STUDENT_ID", grade.getStudentId());
                startActivity(intent);
            }
        });
        adapter.setEvents(courses);
        mRecyclerView.setAdapter(adapter);

        points = grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark();
        mTextViewFitChatPoints.setText(String.valueOf(points));

        mTextViewPointsPassTest.setText(howManyTest(grade));
        mTextViewPointsDoneHomework.setText(howManyHomework(grade));

        mTextViewCounterLessonNumber.setText(String.valueOf(courses.getGroupedTasks().size() - 2));
        mTextViewCounterRemainedLessonNumber.setText(howManyLessonRemained(grade, courses.getGroupedTasks().size() - 2));
        mTextViewCounterPassedLessonNumber.setText(String.valueOf(howManyLessonPassed(grade)));
        mProgressBarLesson.setMax(courses.getGroupedTasks().size() - 2);
        mProgressBarLesson.setProgress(howManyLessonPassed(grade));

        mFitChatPoints.setMaxValue(howManyMaxPoints(courses));
        mFitChatPoints.setValue(grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark());
    }

    @Override
    public void setAvailableCourses(AvailableCourses availableCourses) {
        AvailableCoursesEventsViewAdapter relevantViewAdapter = new AvailableCoursesEventsViewAdapter(points);
        relevantViewAdapter.setEvents(availableCourses);
        mRecyclerViewAvailable.setAdapter(relevantViewAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewSpecificPerformance:
                startActivity(new Intent(getContext(), PerformanceActivity.class));
                break;
            case R.id.textViewSpecificRating:

                break;
        }
    }

    public static String howManyTest(Grade grade) {
        int counterTestAll = 0;
        int counterTestDone = 0;
        for (SubGrade g : grade.getSubGrades()) {
            if (g.getTaskType() == null)
                continue;

            if (g.getTaskType().equals("test_during_lecture")) {
                counterTestAll++;
                if (g.getStatus().equals("accepted")) {
                    counterTestDone++;
                }
            }
        }
        return counterTestDone +"/" + counterTestAll;
    }

    private String howManyHomework(Grade grade) {
        int counterHomeworkAll = 0;
        int counterHomeworkDone = 0;
        for (SubGrade g : grade.getSubGrades()) {
            if (g.getTaskType() == null)
                continue;

            if (g.getTaskType().equals("full")) {
                counterHomeworkAll++;
                if (g.getStatus().equals("accepted")) {
                    counterHomeworkDone++;
                }
            }
        }
        return counterHomeworkDone +"/" + counterHomeworkAll;
    }

    private String howManyLessonRemained(Grade grade, int lessonAll) {
        int counterLessonDone = 2;

        for (SubGrade g : grade.getSubGrades()) {
            if (g.getTaskType() == null)
                continue;
            if (g.getTaskType().equals("test_during_lecture") && g.getStatus().equals("accepted")) {
                    counterLessonDone++;
            }
        }

        return String.valueOf(lessonAll - counterLessonDone);
    }

    private int howManyLessonPassed(Grade grade) {
        int counterLessonDone = 2;

        for (SubGrade g : grade.getSubGrades()) {
            if (g.getTaskType() == null)
                continue;
            if (g.getTaskType().equals("test_during_lecture") && g.getStatus().equals("accepted")) {
                counterLessonDone++;
            }
        }

        return counterLessonDone;
    }

    private float howManyMaxPoints(Courses example) {
        int sum = 0;
        for (int i = 0; i < example.getGroupedTasks().size() - 1; i++) {
            for (int j = 0; j < example.getGroupedTasks().get(i).size(); j++) {
                sum += example.getGroupedTasks().get(i).get(j).getMaxScore();
            }
        }

        return (float) sum;
    }

    @Override
    public void onRefresh() {
        mPresenter.swipeSync();
    }
}
