package com.android_lab.sqlitedemo;

import android.provider.BaseColumns;

public class StudentContract {

    private StudentContract() {}

    public static class StudentEntry implements BaseColumns  {
        public static final String TABLE_NAME = "students";
        public static final String NAME = "name";
        public static final String ROLL_NO = "roll_no";
        public static final String AGE = "age";
    }
}
