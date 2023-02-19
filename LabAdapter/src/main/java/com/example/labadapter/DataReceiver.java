package com.example.labadapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.util.ULocale;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

public class DataReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context  context, Intent intent){
        try{
            if (intent != null){
                Category category = (Category) intent.getSerializableExtra("category");
            }
        }catch(Exception e){
            Log.e("catch", e.toString());
        }
        Toast.makeText(context, "Action: "+intent.getAction(), Toast.LENGTH_LONG).show();
    }
}
