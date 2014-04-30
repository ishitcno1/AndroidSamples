package com.edinstudio.app.samples.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by albert on 14-3-18.
 */
public class SubActivity extends ActionBarActivity {
    public static final String ACTION_CHANGE_SUB = "changeSub";

    private TextView mResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mResponse = (TextView) findViewById(R.id.response);

        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("logtag", "in onReceive");
                updateResponse();
            }
        }, new IntentFilter(ACTION_CHANGE_SUB));
    }

    private void updateResponse() {
        mResponse.setText("Receive from LocalBroadcast");
    }
}
