package com.example.petya.tinkofffintech.activity.statementcourseactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.util.Utils;

import javax.inject.Inject;

import dagger.Lazy;

public class StatementCourseActivity extends AppCompatActivity {

    @Inject
    Lazy<StatementCourseFragment> mPerformanceFragmentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement_course);



        Bundle bundle = new Bundle();
        bundle.putInt("STUDENT_ID", getIntent().getIntExtra("STUDENT_ID", 0));

        App.getApp(this).getComponentsHolder().getStatementCourseComponent().injectStatementCourseActivity(this);

        StatementCourseFragment relevantFragment =
                (StatementCourseFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (relevantFragment == null) {
            relevantFragment = mPerformanceFragmentProvider.get();
            relevantFragment.setArguments(bundle);
            Utils.addFragmentToActivity(
                    getSupportFragmentManager(), relevantFragment, R.id.contentFrame);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseStatementCourseComponent();
        }
    }
}
