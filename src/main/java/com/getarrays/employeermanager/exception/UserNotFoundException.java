package com.getarrays.employeermanager.exception;

public class UserNotFoundException extends  RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
