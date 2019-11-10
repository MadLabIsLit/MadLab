package com.android_lab.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        System.out.println("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        System.out.println("onDestroy()");
    }
}

/*
* Output in Run Tab:
*
* I/System.out: onCreate()      // App Starts
* I/System.out: onStart()
* I/System.out: onResume()
* I/System.out: onPause()       // User presses Home Button
* I/System.out: onStop()
* I/System.out: onStart()       // User open app again
* I/System.out: onResume()
* I/System.out: onPause()       // User presses Recent Apps Button
* I/System.out: onStop()
* I/System.out: onDestroy()     // User close app in Recent Apps
*
* Application Terminated
* */
