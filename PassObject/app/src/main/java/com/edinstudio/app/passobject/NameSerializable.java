package com.edinstudio.app.passobject;

import java.io.Serializable;

/**
 * Created by Albert on 14-4-30.
 */
public class NameSerializable implements Serializable {
    private String firstName;
    private String lastName;

    public NameSerializable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
