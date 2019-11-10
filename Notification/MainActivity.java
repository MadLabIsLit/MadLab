package com.android_lab.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText title, message, phone_no;
    private Button showNotification, showMissedNotification;

    private final static int notification_id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        message = findViewById(R.id.message);
        phone_no = findViewById(R.id.phone_no);

        showNotification = findViewById(R.id.show_notification);
        showNotification.setOnClickListener(this);
        showMissedNotification = findViewById(R.id.show_missed_notification);
        showMissedNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, AppDelegate.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setAutoCancel(true);

        switch (view.getId()) {
            case R.id.show_notification:
                String t = title.getText().toString();
                String m = message.getText().toString();

                notificationBuilder.setContentTitle(t)
                        .setContentText(m);
                break;

            case R.id.show_missed_notification:
                String phone = phone_no.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                notificationBuilder.setContentTitle("Missed Call")
                        .setContentText("You have a missed call from " + phone)
                        .setContentIntent(pendingIntent);
                break;
        }

        notificationManager.notify(notification_id, notificationBuilder.build());
    }
}
