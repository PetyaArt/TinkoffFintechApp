package com.example.petya.tinkofffintech.relevantactivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.di.App;
import com.example.petya.tinkofffintech.mainmenuactivity.events.RelevantEventsViewAdapter;

import javax.inject.Inject;

public class RelevantFragment extends Fragment implements RelevantContract.View {

    @Inject
    RelevantContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    @Inject
    public RelevantFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getRelevantActivityComponent().injectRelevantFragment(this);
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
        return inflater.inflate(R.layout.fragment_relevant, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerViewRelevant);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showNoInternet() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void setAdapter(Events events) {
        RelevantViewAdapter  relevantViewAdapter = new RelevantViewAdapter(getContext());
        relevantViewAdapter.setEvents(events);
        mRecyclerView.setAdapter(relevantViewAdapter);
    }
}
