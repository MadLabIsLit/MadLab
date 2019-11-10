package com.android_lab.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class StudentDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StudentDB.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StudentContract.StudentEntry.TABLE_NAME + " (" +
                    StudentContract.StudentEntry._ID + " INTEGER PRIMARY KEY, " +
                    StudentContract.StudentEntry.NAME + " TEXT, " +
                    StudentContract.StudentEntry.ROLL_NO + " TEXT, " +
                    StudentContract.StudentEntry.AGE + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + StudentContract.StudentEntry.TABLE_NAME;

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    private ContentValues getContentValues(Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentContract.StudentEntry.NAME, student.name);
        values.put(StudentContract.StudentEntry.ROLL_NO, student.rollNo);
        values.put(StudentContract.StudentEntry.AGE, student.age);
        return values;
    }

    public long insert(Student student) {
        SQLiteDatabase db = getWritableDatabase();

        return db.insert(StudentContract.StudentEntry.TABLE_NAME, null, getContentValues(student));
    }

    public ArrayList<Student> getAll() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                StudentContract.StudentEntry.TABLE_NAME,
                null, null,null,null,null,null
        );

        ArrayList<Student> students = new ArrayList<>();

        while(cursor.moveToNext()) {
            Student student = new Student(
                    cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.ROLL_NO)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry.AGE))
            );
            student._ID = cursor.getLong(cursor.getColumnIndexOrThrow(StudentContract.StudentEntry._ID));
            students.add(student);
        }
        cursor.close();

        return students;
    }

    public int update(Student student) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = getContentValues(student);
        String selection = StudentContract.StudentEntry._ID + " = ?";
        String selectionArgs[] = { String.valueOf(student._ID) };

        return db.update(
                StudentContract.StudentEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

    }

    public int delete(long id) {
        SQLiteDatabase db = getReadableDatabase();

        String selection = StudentContract.StudentEntry._ID + " = ?";
        String selectionArgs[] = { String.valueOf(id) };

        return db.delete(
                StudentContract.StudentEntry.TABLE_NAME,
                selection,
                selectionArgs
        );
    }

    public int delete(Student student) {
        return delete(student._ID);
    }
}
