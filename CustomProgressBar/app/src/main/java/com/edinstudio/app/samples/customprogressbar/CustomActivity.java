package com.edinstudio.app.samples.customprogressbar;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.widget.ProgressBar;

/**
 * Created by albert on 14-3-25.
 */
public class CustomActivity extends ActionBarActivity {
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        mProgressBar = (ProgressBar) findViewById(R.id.custom_horizontal_progress);

        new CountDownTimer(5000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                mProgressBar.incrementProgressBy(1);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
