package com.edinstudio.app.passobject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Albert on 14-4-30.
 */
public class SubActivity extends ActionBarActivity {
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mName = (TextView) findViewById(R.id.sub_name);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("type").equals("serializable")) {
            NameSerializable name = (NameSerializable) bundle.getSerializable("name");
            mName.setText(name.getFirstName() + " " + name.getLastName());
        } else {
            NameParcelable name = bundle.getParcelable("name");
            mName.setText(name.getFirsName() + " " + name.getLastName());
        }
    }
}
