package com.example.petya.tinkofffintech.activity.statementcourseactivity.dagger;

import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseActivity;
import com.example.petya.tinkofffintech.activity.statementcourseactivity.StatementCourseFragment;
import com.example.petya.tinkofffintech.di.dagger.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = StatementCourseModule.class)
public interface StatementCourseComponent {
    void injectStatementCourseActivity(StatementCourseActivity relevantActivity);
    void injectStatementCourseFragment(StatementCourseFragment relevantFragment);
}
