package com.example.petya.tinkofffintech.authactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.petya.tinkofffintech.R;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class AuthFragment extends DaggerFragment implements AuthContract.View {

    @Inject
    AuthContract.Presenter mPresenter;

    private EditText mLogin;
    private EditText mPassword;
    private Button mButtonAuth;

    @Inject
    public AuthFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        return root;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
