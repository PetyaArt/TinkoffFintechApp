package com.example.petya.tinkofffintech.splashactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.petya.tinkofffintech.R;
import com.example.petya.tinkofffintech.authactivity.AuthActivity;
import com.example.petya.tinkofffintech.network.RetrofitInstance;
import com.example.petya.tinkofffintech.network.SingInBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    public static final int SPLASH_DURATION = 0;

    private ImageView mImageView;
    private ConstraintLayout mConstraintLayout;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mConstraintLayout = findViewById(R.id.splash_layout);
        mImageView = findViewById(R.id.splash_icon);
        mAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
    }

    private void initFunctionality() {
        mConstraintLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mImageView.startAnimation(mAnimation);
                mAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //TODO: открытие другого Activity
                        Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, SPLASH_DURATION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initFunctionality();
    }

}
