package com.edinstudio.app.samples.readsms;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.Telephony;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity implements LoaderManager.LoaderCallbacks {
    // read sms of last week
    private int offsetDay = -7;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.content);


        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        Uri uri = Uri.parse("content://sms/inbox");
        String[] projection = {BaseColumns._ID, Telephony.TextBasedSmsColumns.PERSON,
                Telephony.TextBasedSmsColumns.BODY, Telephony.TextBasedSmsColumns.DATE};
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, offsetDay);
        String selection = Telephony.TextBasedSmsColumns.DATE + ">=?";
        String[] selectionArgs = {String.valueOf(calendar.getTimeInMillis())};
        return new CursorLoader(this, uri, projection, selection, selectionArgs,
                Telephony.Sms.Inbox.DEFAULT_SORT_ORDER);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        Cursor cursor = (Cursor) data;
        SMSCursorAdapter adapter = new SMSCursorAdapter(this, cursor);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    class SMSCursorAdapter extends CursorAdapter {
        LayoutInflater inflater;

        public SMSCursorAdapter(Context context, Cursor cursor) {
            super(context, cursor, 0);
            inflater = LayoutInflater.from(context);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return inflater.inflate(R.layout.list_item_sms, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView sender = (TextView) view.findViewById(R.id.sms_sender);
            TextView bodySummary = (TextView) view.findViewById(R.id.sms_body_summary);
            TextView gottenTime = (TextView) view.findViewById(R.id.sms_gotten_time);

            sender.setText(cursor.getString(
                    cursor.getColumnIndex(Telephony.TextBasedSmsColumns.PERSON)
            ));

            bodySummary.setText(cursor.getString(
                    cursor.getColumnIndex(Telephony.TextBasedSmsColumns.BODY)
            ));

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.valueOf(
                    cursor.getString(
                            cursor.getColumnIndex(Telephony.TextBasedSmsColumns.DATE))
            ));
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            gottenTime.setText(format.format(calendar.getTime()));
        }
    }
}
