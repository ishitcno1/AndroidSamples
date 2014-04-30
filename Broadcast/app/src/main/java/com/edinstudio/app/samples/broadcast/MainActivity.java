package com.edinstudio.app.samples.broadcast;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public static final String ACTION_CHANGE_MAIN = "changeMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendLocalBroadcast(View view) {
        Intent intent = new Intent(SubActivity.ACTION_CHANGE_SUB);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    public void sendBroadcast(View view) {

    }

    public void goSub(View view) {
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }
}
