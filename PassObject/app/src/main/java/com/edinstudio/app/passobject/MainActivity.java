package com.edinstudio.app.passobject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private EditText mFirstName;
    private EditText mLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstName = (EditText) findViewById(R.id.main_first_name);
        mLastName = (EditText) findViewById(R.id.main_last_name);
    }

    public void passThroughSerializable(View view) {
        NameSerializable name = new NameSerializable(mFirstName.getText().toString(),
                mLastName.getText().toString());
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("type", "serializable");
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void passThroughParcelable(View view) {
        NameParcelable name = new NameParcelable(mFirstName.getText().toString(),
                mLastName.getText().toString());
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("type", "parcelable");
        intent.putExtra("name", name);
        startActivity(intent);
    }

}
