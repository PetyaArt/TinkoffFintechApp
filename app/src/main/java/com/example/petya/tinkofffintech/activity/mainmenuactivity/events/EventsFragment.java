package com.example.petya.tinkofffintech.activity.mainmenuactivity.events;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.activity.pastactivity.PastActivity;
import com.example.petya.tinkofffintech.activity.relevantactivity.RelevantActivity;
import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class EventsFragment extends Fragment implements EventsContract.View, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    EventsContract.Presenter mPresenter;

    private RecyclerView mRelevantRecyclerView;
    private RecyclerView mPastRecyclerView;
    private TextView mCounterRelevant;
    private TextView mCounterPast;
    private SwipeRefreshLayout mSwipeRefresh;

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
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            Toolbar toolbar = view.findViewById(R.id.toolbarEvents);
            toolbar.setTitle(R.string.events);
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        }

        mRelevantRecyclerView = view.findViewById(R.id.recyclerViewRelevantEvents);
        mRelevantRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mPastRecyclerView = view.findViewById(R.id.recyclerViewPastEvents);
        mPastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mCounterRelevant = view.findViewById(R.id.counterRelevant);
        mCounterPast = view.findViewById(R.id.counterPast);
        mCounterRelevant.setOnClickListener(this);
        mCounterPast.setOnClickListener(this);

        mSwipeRefresh = view.findViewById(R.id.swiperefreshEvents);
        mSwipeRefresh.setOnRefreshListener(this);
    }

    @Override
    public void offSwipeRefresh() {
        mSwipeRefresh.setRefreshing(false);
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
    public void setAdapter(EventsData eventsData) {
        RelevantEventsViewAdapter relevantViewAdapter = new RelevantEventsViewAdapter(getContext(),
                eventsData.getUnsplash().getResults());
        relevantViewAdapter.setEvents(eventsData.getEvents());
        mRelevantRecyclerView.setAdapter(relevantViewAdapter);

        PastEventsViewAdapter pastViewAdapter= new PastEventsViewAdapter();
        pastViewAdapter.setEvents(eventsData.getEvents());
        mPastRecyclerView.setAdapter(pastViewAdapter);

        mCounterRelevant.setText(String.format("%s %s", getString(R.string.all), String.valueOf(eventsData.getEvents().getActive().size())));
        mCounterPast.setText(String.format("%s %s", getString(R.string.all), String.valueOf(eventsData.getEvents().getArchive().size())));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.counterRelevant:
                startActivity(new Intent(getContext(), RelevantActivity.class));
                break;
            case R.id.counterPast:
                startActivity(new Intent(getContext(), PastActivity.class));
                break;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.swipeSync();
    }
}
