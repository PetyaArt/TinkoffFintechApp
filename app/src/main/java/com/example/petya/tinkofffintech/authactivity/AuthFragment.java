package com.example.petya.tinkofffintech.authactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.di.App;

import javax.inject.Inject;

public class AuthFragment extends Fragment implements AuthContract.View, View.OnClickListener {

    @Inject
    AuthContract.Presenter mPresenter;

    private EditText mLogin;
    private EditText mPassword;
    private Button mButtonAuth;
    private ProgressBar mProgressBar;

    @Inject
    public AuthFragment() {
        // Requires empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null) {
            App.getApp(getContext()).getComponentsHolder().getAuthActivityComponent().injectAuthFragment(this);
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
        View root = inflater.inflate(R.layout.fragment_auth, container, false);

        mLogin = root.findViewById(R.id.editTextLogin);
        mPassword = root.findViewById(R.id.editTextPassword);
        mButtonAuth = root.findViewById(R.id.buttonAuth);
        mProgressBar = root.findViewById(R.id.progressBar);

        mButtonAuth.setOnClickListener(this);

        return root;
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

    @Override
    public void showFieldEmpty() {
        showMessage(getString(R.string.field_empty));
    }

    private void showMessage(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.buttonPress(mLogin.getText().toString(), mPassword.getText().toString());
    }
}
