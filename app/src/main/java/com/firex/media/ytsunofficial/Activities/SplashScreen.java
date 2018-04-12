package com.firex.media.ytsunofficial.Activities;

import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.firex.media.ytsunofficial.R;

public class SplashScreen extends AppCompatActivity {

    private ImageView imgLogo;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imgLogo = findViewById(R.id.imgLogo);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);
        imgLogo.setScaleX(0.1f);
        imgLogo.setScaleY(0.1f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imgLogo.animate().scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new OvershootInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }
}
