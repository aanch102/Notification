package com.aanchal.notification;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myService extends Service {

    public Context context=this;
    public Handler handler=null;
    public Runnable runnable=null;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(context, "Service Created", Toast.LENGTH_SHORT).show();

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                Double randomNo =getRamdomDoubleBetweenRange(1,100);
                Toast.makeText(context, "Random no", Toast.LENGTH_SHORT).show();
                handler.postDelayed(runnable,2000);
            }
        };
        handler.postDelayed(runnable,2000);
    }

    public static  double getRamdomDoubleBetweenRange(double min,double max){
        return  (Math.random()*((max-min)+1))+min;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        Toast.makeText(context, "addservices stopped", Toast.LENGTH_SHORT).show();
    }
}
