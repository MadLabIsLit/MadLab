package com.android_lab.sqlitedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, StudentAdapter.OnClicklistener {

    private Toolbar toolbar;
    private ImageButton add, reload;

    private RecyclerView recyclerView;
    private StudentAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Student> students;
    private StudentDbHelper dbHelper;

    public static String STUDENT_ID = "MainActivity.Student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setupRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        dbHelper = new StudentDbHelper(this);
        reloadData();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        reload = findViewById(R.id.reload);
        reload.setOnClickListener(this);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new StudentAdapter(students, this);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    private void reloadData() {
        students = dbHelper.getAll();
        mAdapter.update(students);
        Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                startActivity(new Intent(this, DetailActivity.class));
                break;
            case R.id.reload:
                Toast.makeText(this, "Reloading Data", Toast.LENGTH_SHORT).show();
                reloadData();
                break;
        }
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(STUDENT_ID, students.get(position));
        startActivity(intent);
    }
}
