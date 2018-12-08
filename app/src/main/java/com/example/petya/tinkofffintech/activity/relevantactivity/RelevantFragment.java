package com.example.petya.tinkofffintech.activity.relevantactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.data.animedata.EventsData;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class RelevantFragment extends Fragment implements RelevantContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    RelevantContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private SwipeRefreshLayout mSwipeRefreshLayout;

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
        mSwipeRefreshLayout = view.findViewById(R.id.swiperefreshRelevant);
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
    public void setAdapter(EventsData eventsData) {
        RelevantViewAdapter relevantViewAdapter = new RelevantViewAdapter(getContext(), eventsData.getUnsplash().getResults());
        relevantViewAdapter.setEvents(eventsData.getEvents());
        mRecyclerView.setAdapter(relevantViewAdapter);
    }

    @Override
    public void onRefresh() {
        mPresenter.swipeSync();
    }
}
