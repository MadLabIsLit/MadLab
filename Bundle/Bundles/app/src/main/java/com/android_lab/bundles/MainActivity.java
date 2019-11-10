package com.android_lab.bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name, age;
    private Spinner gender;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.cname);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);

        done = findViewById(R.id.done);
        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", name.getText().toString());
        bundle.putString("age", age.getText().toString());
        bundle.putString("gender", gender.getSelectedItem().toString());

        Intent intent = new Intent(this, ConfirmActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
    }
}
