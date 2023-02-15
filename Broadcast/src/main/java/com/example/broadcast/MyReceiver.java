package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, @NonNull Intent intent){
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean myConnection= intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if(myConnection){
                Toast.makeText(context, "False", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context, "true", Toast.LENGTH_LONG).show();
            }
        }
    }
}
