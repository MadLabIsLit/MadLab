package com.android_lab.shared_prefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name, rollNo;

    public static final String USER_PREF = "USER_PREF" ;
    public static final String NAME_KEY = "NAME";
    public static final String ROLLNO_KEY = "ROLLNO";

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        rollNo = findViewById(R.id.roll_no);

        sharedPreferences = getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);
    }

    public void save(View view) {
        String n = name.getText().toString();
        String r = rollNo.getText().toString();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, n);
        editor.putString(ROLLNO_KEY, r);
        editor.commit();

        Toast.makeText(this, "Saved Shared Preferences", Toast.LENGTH_LONG).show();
    }

    public void retrieve(View view) {
        if(sharedPreferences.contains(NAME_KEY))
            name.setText(sharedPreferences.getString(NAME_KEY,""));

        if(sharedPreferences.contains(ROLLNO_KEY))
            rollNo.setText((sharedPreferences.getString(ROLLNO_KEY, "")));

        Toast.makeText(this, "Retrieved Shared Preferences", Toast.LENGTH_LONG).show();
    }

    public void clear(View view) {
        name.setText("");
        rollNo.setText("");

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

        Toast.makeText(this, "Cleared Shared Preferences", Toast.LENGTH_LONG).show();
    }
}
