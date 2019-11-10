package com.android_lab.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText uname, pwd;
    private Button login;

    private String UNAME = "cvrcsec";
    private String PWD = "cvr123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.uname);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String uname = this.uname.getText().toString();
        String pwd = this.pwd.getText().toString();

        if(uname.equals(UNAME) && pwd.equals(PWD))
            Toast.makeText(this, "Welcome, " + uname, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
    }
}
