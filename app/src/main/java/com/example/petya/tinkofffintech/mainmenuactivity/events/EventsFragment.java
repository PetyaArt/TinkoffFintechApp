package com.example.petya.tinkofffintech.mainmenuactivity.events;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.event.Events;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class EventsFragment extends Fragment implements EventsContract.View, View.OnClickListener{

    @Inject
    EventsContract.Presenter mPresenter;

    private RecyclerView mRelevantRecyclerView;
    private RecyclerView mPastRecyclerView;
    private TextView mCounterRelevant;
    private TextView mCounterPast;

    @Inject
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getMainMenuComponent().injectEventsFragment(this);
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRelevantRecyclerView = view.findViewById(R.id.recyclerViewRelevant);
        mRelevantRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mPastRecyclerView = view.findViewById(R.id.recyclerViewPast);
        mPastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mCounterRelevant = view.findViewById(R.id.counterRelevant);
        mCounterPast = view.findViewById(R.id.counterPast);
        mCounterRelevant.setOnClickListener(this);
        mCounterPast.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        //mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        //mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showNoInternet() {
        showMessage(getString(R.string.no_internet));
    }

    @Override
    public void showError() {
        showMessage(getString(R.string.error));
    }

    @Override
    public void setAdapter(Events events) {
        RelevantViewAdapter relevantViewAdapter = new RelevantViewAdapter();
        relevantViewAdapter.setEvents(events);
        mRelevantRecyclerView.setAdapter(relevantViewAdapter);

        PastViewAdapter pastViewAdapter= new PastViewAdapter();
        pastViewAdapter.setEvents(events);
        mPastRecyclerView.setAdapter(pastViewAdapter);

        mCounterRelevant.setText(events.getActive().size());
        mCounterPast.setText(events.getArchive().size());
    }

    private void showMessage(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.counterRelevant:
                //TODO: открытие другого Activity
                break;
            case R.id.counterPast:
                //TODO: открытие другого Activity
                break;
        }
    }
}
