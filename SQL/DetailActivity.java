package com.android_lab.sqlitedemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private Toolbar toolbar;
    private ImageButton done, delete;

    private EditText name, rollNo, age;

    private Student student;
    private StudentDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbHelper = new StudentDbHelper(this);

        setupToolbar();
        initializeForm();
        setupForm();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        done = findViewById(R.id.done);
        done.setOnClickListener(this);
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(this);
    }

    private void initializeForm() {
        name = findViewById(R.id.name);
        rollNo = findViewById(R.id.roll_no);
        age = findViewById(R.id.age);
    }

    private void setupForm() {
        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.STUDENT_ID)) {
            student = (Student) intent.getSerializableExtra(MainActivity.STUDENT_ID);

            setTitle(student.name + " Details");
            delete.setVisibility(View.VISIBLE);

            name.setText(student.name);
            rollNo.setText(student.rollNo);
            age.setText(String.valueOf(student.age));
        } else {
            student = null;

            setTitle("New Student");
            done.setEnabled(false);
        }

        name.addTextChangedListener(this);
        rollNo.addTextChangedListener(this);
        age.addTextChangedListener(this);
    }

    private Student getUpdatedObject() {
        if(student == null)
            return new Student(
                    name.getText().toString(),
                    rollNo.getText().toString(),
                    Integer.parseInt(age.getText().toString()));

        student.name = name.getText().toString();
        student.rollNo = rollNo.getText().toString();
        student.age = Integer.parseInt(age.getText().toString());

        return student;
    }

    private void update(Student student) {
        if(this.student == null) {
            dbHelper.insert(student);
            Toast.makeText(this, "Inserted New Record", Toast.LENGTH_SHORT).show();
        } else {
            dbHelper.update(student);
            Toast.makeText(this, "Updated Record", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.done:
                update(getUpdatedObject());
                finish();
                break;
            case R.id.delete:
                dbHelper.delete(student);
                Toast.makeText(this, "Deleted Record", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void afterTextChanged(Editable editable) {
        done.setEnabled(
                name.getText().toString().length() > 0 &&
                rollNo.getText().toString().length() > 0 &&
                age.getText().toString().length() > 0
        );
    }
}
