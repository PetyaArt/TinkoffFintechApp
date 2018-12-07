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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.courses.Example;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.courses.SubGrade;
import com.example.petya.tinkofffintech.di.App;
import com.txusballesteros.widgets.FitChart;

import javax.inject.Inject;

public class MyCoursesFragment extends Fragment implements MyCoursesContract.View, View.OnClickListener {

    @Inject
    MyCoursesContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
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
    private Toolbar mToolbar;

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
            mToolbar = view.findViewById(R.id.toolbarCourses);
            mToolbar.setTitle(R.string.my_course);
            ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        }

        mRecyclerView = view.findViewById(R.id.recyclerViewMyCourses);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

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
        Grade grade = null;
        for (Grade g: example.getGrades()) {
            if (g.getStudentId() == 5350) {
                grade = g;
            }
        }
        AcademicPerformanceViewAdapter adapter = new AcademicPerformanceViewAdapter();
        adapter.setEvents(example);
        mRecyclerView.setAdapter(adapter);

        mTextViewFitChatPoints.setText(String.valueOf((grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark())));
        mTextViewPointsPassTest.setText(howManyTest(grade));
        mTextViewPointsDoneHomework.setText(howManyHomework(grade));
        //TODO: сделать сортировку и вытащить себя
        mTextViewCounterLessonNumber.setText(String.valueOf(example.getGroupedTasks().size() - 2));
        mTextViewCounterRemainedLessonNumber.setText(howManyLessonRemained(grade, example.getGroupedTasks().size() - 2));
        mTextViewCounterPassedLessonNumber.setText(String.valueOf(howManyLessonPassed(grade)));
        mProgressBarLesson.setMax(example.getGroupedTasks().size() - 2);
        mProgressBarLesson.setProgress(howManyLessonPassed(grade));

        mFitChatPoints.setMaxValue(howManyMaxPoints(example));
        mFitChatPoints.setValue(grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textViewSpecificPerformance:

                break;
            case R.id.textViewSpecificRating:

                break;
        }
    }

    private String howManyTest(Grade grade) {
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
            //TODO: плохая json не понимаю как определить дз
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

    private float howManyMaxPoints(Example example) {
        int sum = 0;
        for (int i = 0; i < example.getGroupedTasks().size() - 1; i++) {
            for (int j = 0; j < example.getGroupedTasks().get(i).size(); j++) {
                sum += example.getGroupedTasks().get(i).get(j).getMaxScore();
            }
        }

        return (float) sum;
    }
}
