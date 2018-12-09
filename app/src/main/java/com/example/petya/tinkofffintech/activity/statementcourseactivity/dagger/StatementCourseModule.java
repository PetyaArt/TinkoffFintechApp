package com.example.petya.tinkofffintech.activity.statementcourseactivity.dagger;

import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseContract;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseFragment;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCoursePresenter;
import com.example.petya.tinkofffintech.data.source.Repository;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Module;
import dagger.Provides;

@Module
public class StatementCourseModule {

    @ActivityScoped
    @Provides
    StatementCourseFragment statementCourseFragment() {
        return new StatementCourseFragment();
    }

    @ActivityScoped
    @Provides
    StatementCourseContract.Presenter statementCoursePresenter(Repository repository) {
        return new StatementCoursePresenter(repository);
    }
}
