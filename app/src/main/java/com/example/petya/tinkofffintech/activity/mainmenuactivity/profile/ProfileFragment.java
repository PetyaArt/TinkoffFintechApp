package com.example.petya.tinkofffintech.activity.mainmenuactivity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.activity.authactivity.AuthActivity;
import com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses.AcademicPerformanceViewAdapter;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseActivity;
import com.example.petya.tinkofffintech.data.animedata.ProfileData;
import com.example.petya.tinkofffintech.data.animedata.courses.Courses;
import com.example.petya.tinkofffintech.data.animedata.courses.Grade;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.util.storage.Preferences;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import javax.inject.Inject;

import static com.example.petya.tinkofffintech.activity.mainmenuactivity.mycourses.MyCoursesFragment.howManyTest;

public class ProfileFragment extends Fragment implements ProfileContract.View {

    @Inject
    ProfileContract.Presenter mPresenter;

    private ImageView mImageViewAvatar;

    private RecyclerView mRecyclerViewProfilePerformance;

    private TextView mTextViewNameProfile;
    private TextView mTextViewMailProfile;

    private TextView mTextViewNameAndAge;
    private TextView mTextViewMyTeam;

    private TextView mTextViewMobilePhone;
    private TextView mTextViewMail;
    private TextView mTextViewCity;
    private TextView mTextViewSchool;
    private TextView mTextViewEndSchool;
    private TextView mTextViewHei;
    private TextView mTextViewFaculty;
    private TextView mTextViewEndHei;
    private TextView mTextViewDepartment;
    private TextView mTextViewCurrentWork;

    private TextView mTextViewScore;
    private TextView mTextViewTest;
    private TextView mTextViewCounterCourse;
    private TextView mTextViewStatus;

    private ProgressBar mProgressBar;


    @Inject
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getMainMenuComponent().injectProfileFragment(this);
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            Toolbar toolbar = view.findViewById(R.id.toolbarProfile);
            toolbar.inflateMenu(R.menu.menu_fragment_profile);
            toolbar.setTitle("");
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        mRecyclerViewProfilePerformance = view.findViewById(R.id.recyclerViewProfilePerformance);

        mProgressBar = view.findViewById(R.id.progressBarProfile);

        mTextViewNameProfile = view.findViewById(R.id.textViewNameProfile);
        mTextViewMailProfile = view.findViewById(R.id.textViewMailProfile);

        mTextViewNameAndAge = view.findViewById(R.id.textViewNameAndAge);
        mTextViewMyTeam = view.findViewById(R.id.textViewMyTeam);

        mTextViewMobilePhone = view.findViewById(R.id.textViewMobilePhone);
        mTextViewMail = view.findViewById(R.id.textViewMail);
        mTextViewCity = view.findViewById(R.id.textViewCity);
        mTextViewSchool = view.findViewById(R.id.textViewSchool);
        mTextViewEndSchool = view.findViewById(R.id.textViewEndSchool);
        mTextViewHei = view.findViewById(R.id.textViewHei);
        mTextViewFaculty = view.findViewById(R.id.textViewFaculty);
        mTextViewEndHei = view.findViewById(R.id.textViewEndHei);
        mTextViewDepartment = view.findViewById(R.id.textViewDepartment);
        mTextViewCurrentWork = view.findViewById(R.id.textViewCurrentWork);
        mImageViewAvatar = view.findViewById(R.id.app_bar_image);

        mTextViewScore = view.findViewById(R.id.textViewScore);
        mTextViewTest = view.findViewById(R.id.textViewTest);
        mTextViewCounterCourse = view.findViewById(R.id.textViewCounterCourse);
        mTextViewStatus = view.findViewById(R.id.textViewStatus);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (getActivity() == null)
            return false;
        switch (item.getItemId()) {
            case R.id.singout:
                mPresenter.signOut();
                new Preferences(getActivity()).setCookies(new HashSet<String>());
                startActivity(new Intent(getActivity(), AuthActivity.class));
                getActivity().finish();
                break;
            case R.id.update:
                mPresenter.swipeSync();
                break;
        }
        return true;
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
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
    public void showData(ProfileData profileData) {
        try {
            mTextViewNameProfile.setText(String.format("%s %s", profileData.getProfile().getUser().getLastName(), profileData.getProfile().getUser().getFirstName()));
            mTextViewMailProfile.setText(profileData.getProfile().getUser().getEmail());

            mTextViewNameAndAge.setText(String.format("%s %s, %s",
                    profileData.getProfile().getUser().getLastName(),
                    profileData.getProfile().getUser().getFirstName(),
                    getAge(profileData.getProfile().getUser().getBirthday())));
            mTextViewMobilePhone.setText(profileData.getProfile().getUser().getPhoneMobile());
            mTextViewMail.setText(profileData.getProfile().getUser().getEmail());
            mTextViewCity.setText(profileData.getProfile().getUser().getRegion());
            mTextViewSchool.setText(profileData.getProfile().getUser().getSchool());
            mTextViewEndSchool.setText(profileData.getProfile().getUser().getSchoolGraduation());
            mTextViewHei.setText(profileData.getProfile().getUser().getUniversity());
            mTextViewFaculty.setText(profileData.getProfile().getUser().getFaculty());
            mTextViewEndHei.setText(String.valueOf(profileData.getProfile().getUser().getUniversityGraduation()));
            mTextViewDepartment.setText(profileData.getProfile().getUser().getDepartment());
            mTextViewCurrentWork.setText(profileData.getProfile().getUser().getCurrentWork());
            mTextViewStatus.setText(profileData.getProfile().getUser().getDescription());
            mTextViewCounterCourse.setText(String.valueOf(profileData.getAvailableCourses().getCourses().size()));
            Picasso.get().load("https://fintech.tinkoff.ru" + profileData.getProfile().getUser().getAvatar()).into(mImageViewAvatar);
        } catch (NullPointerException ignored) {

        }
    }

    @Override
    public void setAdapter(Courses courses) {
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
        mRecyclerViewProfilePerformance.setAdapter(adapter);

        mTextViewMyTeam.setText(courses.getName());
        mTextViewScore.setText(String.valueOf((grade.getSubGrades().get(grade.getSubGrades().size() - 1).getMark())));
        mTextViewTest.setText(howManyTest(grade));
    }



    private String getAge(String birthday) {
        Calendar cal = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        Date date = null;
        try {
            date = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dob.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = age;

        return ageInt.toString();
    }
}
