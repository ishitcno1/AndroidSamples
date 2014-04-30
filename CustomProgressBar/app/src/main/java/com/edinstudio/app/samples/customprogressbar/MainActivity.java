package com.edinstudio.app.samples.customprogressbar;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {
SeekBar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void original(View view) {
        Intent intent = new Intent(this, OriginalActivity.class);
        startActivity(intent);
    }

    public void custom(View view) {
        Intent intent = new Intent(this, CustomActivity.class);
        startActivity(intent);
    }
}
