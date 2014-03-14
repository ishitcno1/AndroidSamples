package com.edinstudio.app.samples.multiplerowradiobuttons;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private RadioGroup mFirstGroup;
    private RadioGroup mSecondGroup;

    private boolean isChecking = true;
    private int mCheckedId = R.id.type1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstGroup = (RadioGroup) findViewById(R.id.first_group);
        mSecondGroup = (RadioGroup) findViewById(R.id.second_group);

        mFirstGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mSecondGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });

        mSecondGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1 && isChecking) {
                    isChecking = false;
                    mFirstGroup.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });
    }

    public void showType(View view) {
        if (mCheckedId == R.id.type1) {
            Toast.makeText(this, "type1", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type2) {
            Toast.makeText(this, "type2", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type3) {
            Toast.makeText(this, "type3", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type4) {
            Toast.makeText(this, "type4", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type5) {
            Toast.makeText(this, "type5", Toast.LENGTH_SHORT).show();
        } else if (mCheckedId == R.id.type6) {
            Toast.makeText(this, "type6", Toast.LENGTH_SHORT).show();
        }
    }
}
