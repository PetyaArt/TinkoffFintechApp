package com.example.petya.tinkofffintech.mainmenuactivity.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.profile.Profile;
import com.example.petya.tinkofffintech.di.App;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

public class ProfileFragment extends Fragment implements ProfileContract.View {

    @Inject
    ProfileContract.Presenter mPresenter;

    ImageView mImageViewAvatar;

    RecyclerView mRecyclerViewProfilePerformance;

    TextView mTextViewNameProfile;
    TextView mTextViewMailProfile;

    TextView mTextViewNameAndAge;
    TextView mTextViewMyTeam;

    TextView mTextViewMobilePhone;
    TextView mTextViewMail;
    TextView mTextViewCity;
    TextView mTextViewSchool;
    TextView mTextViewEndSchool;
    TextView mTextViewHei;
    TextView mTextViewFaculty;
    TextView mTextViewEndHei;
    TextView mTextViewDepartment;
    TextView mTextViewCurrentWork;

    TextView mTextViewScore;
    TextView mTextViewTest;
    TextView mTextViewCounterCourse;
    TextView mTextViewstatus;


    @Inject
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getMainMenuComponent().injectProfileFragment(this);
        }
        setHasOptionsMenu(true);
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
            Toolbar toolbar = view.findViewById(R.id.toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        mRecyclerViewProfilePerformance = view.findViewById(R.id.recyclerViewProfilePerformance);
        //TODO: сделать recycleView с успеваимостью

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
        mTextViewstatus = view.findViewById(R.id.textViewStatus);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
    public void showData(Profile profile) {
        mTextViewNameProfile.setText(String.format("%s %s", profile.getUser().getLastName(), profile.getUser().getFirstName()));
        mTextViewMailProfile.setText(profile.getUser().getEmail());

        mTextViewNameAndAge.setText(String.format("%s %s, %s",
                profile.getUser().getLastName(),
                profile.getUser().getFirstName(),
                getAge(profile.getUser().getBirthday())));
        //mTextViewMyTeam
        mTextViewMobilePhone.setText(profile.getUser().getPhoneMobile());
        mTextViewMail.setText(profile.getUser().getEmail());
        mTextViewCity.setText(profile.getUser().getRegion());
        mTextViewSchool.setText(profile.getUser().getSchool());
        mTextViewEndSchool.setText(profile.getUser().getSchoolGraduation());
        mTextViewHei.setText(profile.getUser().getUniversity());
        mTextViewFaculty.setText(profile.getUser().getFaculty());
        mTextViewEndHei.setText(String.valueOf(profile.getUser().getUniversityGraduation()));
        mTextViewDepartment.setText(profile.getUser().getDepartment());
        mTextViewCurrentWork.setText(profile.getUser().getCurrentWork());
        mTextViewstatus.setText(profile.getUser().getDescription());
        Picasso.get().load("https://fintech.tinkoff.ru" + profile.getUser().getAvatar()).into(mImageViewAvatar);

        //TODO:добавить удаление блоков когда данных не поступает
        //TODO:возможность звонить
    }


    //TODO: может быть сделать более красивее
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
