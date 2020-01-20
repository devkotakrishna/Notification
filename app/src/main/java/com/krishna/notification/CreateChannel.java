package com.krishna.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
    Context context;





    public final static String CHANNEL_1 ="Channel_1";
    public final static String CHANNEL_2="Channel_2";


    public CreateChannel(Context context) {
        this.context = context;
    }

    public void createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 =new NotificationChannel( CHANNEL_1,"Channel_1", NotificationManager.IMPORTANCE_HIGH);
             channel1.setDescription("This is channel1");
             NotificationChannel channel2=new NotificationChannel(CHANNEL_2,"Channel_2",NotificationManager.IMPORTANCE_HIGH);
             channel2.setDescription("this is channel2");

             NotificationManager manager =context.getSystemService(NotificationManager.class);

        }
    }
}
