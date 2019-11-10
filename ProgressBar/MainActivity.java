package com.android_lab.progress_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Handler progressBarHandler = new Handler();
    ProgressDialog progressBar;
    int progressBarStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        progressBar = new ProgressDialog(this);
        progressBar.setIndeterminate(false);
        progressBar.setTitle("Downloading File");
        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressBar.setCanceledOnTouchOutside(false);
        progressBar.setCancelable(false);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        progressBar.show();

        downloadFile();
    }

    private void downloadFile() {
        // This function doesn't download a file, it just updates progress bar
        progressBarStatus = 0;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (getProgressStatus() < 100) {
                    progressBarHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(updateProgressStatus());
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                progressBar.dismiss();
            }
        }).start();
    }

    public int getProgressStatus() {
        return progressBarStatus;
    }

    public int updateProgressStatus() {
        return ++progressBarStatus;
    }
}
