package com.aanchal.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {

    Context context;
    public  final static String CHANNEL_1="Channel1";
    public  final static String CHANNEL_2="Channel2";


    public CreateChannel(Context context) {
        this.context = context;
    }


    public void createChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel Channel1= new NotificationChannel(
                    CHANNEL_1,
                    "Channel_1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            Channel1.setDescription("this is channel1 ");
            NotificationChannel Channel2= new NotificationChannel(
                    CHANNEL_2,
                    "Channel_2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            Channel2.setDescription("this is channel 2 ");

            NotificationManager manager =context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(Channel1);
            manager.createNotificationChannel(Channel2);

        }
    }
}
