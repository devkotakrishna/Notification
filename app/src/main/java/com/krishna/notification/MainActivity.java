package com.krishna.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private NotificationManagerCompat notificationManagerCompat;
    private Button btnDisplayNotification, btnDisplayNotification2;
    private int Count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplayNotification=findViewById(R.id.noti1);
        btnDisplayNotification2=findViewById(R.id.noti2);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel =new CreateChannel(this);
        channel.createChannel();

        btnDisplayNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });

        btnDisplayNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });
    }

    private void DisplayNotification2() {
        Notification notification =new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_adb_black_24dp)
                .setContentTitle("Second message")
                .setContentText("second message body")
                .setCategory(Notification.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(Count,notification);
        Count++;

    }

    private void DisplayNotification() {
        Notification notification =new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First message body")
                .setCategory(Notification.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(Count,notification);
        Count++;

    }
}
