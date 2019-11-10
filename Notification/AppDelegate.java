package com.android_lab.notifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class AppDelegate extends Application {

    final static String CHANNEL_ID_1 = "messages";
    final static String CHANNEL_ID_2 = "missed_calls";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel_1 = new NotificationChannel(CHANNEL_ID_1,
                    "Messages",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationChannel channel_2 = new NotificationChannel(CHANNEL_ID_2,
                    "Missed calls",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel_1);
            notificationManager.createNotificationChannel(channel_2);
        }
    }
}
