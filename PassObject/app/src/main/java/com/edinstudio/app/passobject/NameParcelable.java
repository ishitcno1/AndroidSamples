package com.edinstudio.app.passobject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Albert on 14-4-30.
 */
public class NameParcelable implements Parcelable {
    private String firsName;
    private String lastName;

    public NameParcelable(String firsName, String lastName) {
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public NameParcelable(Parcel soruce) {
        this.firsName = soruce.readString();
        this.lastName = soruce.readString();
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firsName);
        dest.writeString(lastName);
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new NameParcelable(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[0];
        }
    };
}
