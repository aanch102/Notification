package com.aanchal.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

@RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
public class MainActivity extends AppCompatActivity {

    BroadCastReceiverExample broadCastReceiverExample=new BroadCastReceiverExample();
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnnoti1;
    private Button btnnoti2;
    Button btnstart,btnstop;
    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel =new CreateChannel(this);
        channel.createChannel();
        btnnoti1=findViewById(R.id.btnnoti1);
        btnnoti2=findViewById(R.id.btnnoti2);

        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });

        btnnoti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });

        btnnoti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });




    }

    private void startMyService(){
        startService(new Intent(this,myService.class));

    }
    private  void stopMyService(){
        stopService(new Intent(this,myService.class));
    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastReceiverExample,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(broadCastReceiverExample);
    }

    private void DisplayNotification(){
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_favorite_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;


    }

   /* private static final String KEY_TEXT_REPLY = "key_text_reply";

    String replyLabel = getResources().getString(R.string.reply_label);
    RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
            .setLabel(replyLabel)
            .build();

    // Build a PendingIntent for the reply action to trigger.
    PendingIntent replyPendingIntent =
            PendingIntent.getBroadcast(getApplicationContext(),
                    conversation.getConversationId(),
                    getMessageReplyIntent(conversation.getConversationId()),
                    PendingIntent.FLAG_UPDATE_CURRENT);
*/


    private void DisplayNotification2(){
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_add_alert_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(id,notification);
        id++;


    }
}
