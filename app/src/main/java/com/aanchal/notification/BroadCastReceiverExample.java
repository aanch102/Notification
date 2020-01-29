package com.aanchal.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class BroadCastReceiverExample extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity=intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            if (noConnectivity){
                Toast.makeText(context, "not connected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "connected", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
