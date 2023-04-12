package com.example.practical18;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    public MyLocalBinder localBinder = new MyLocalBinder();


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public String getSystemTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss   dd/mm/yy", Locale.US);
        return simpleDateFormat.format(new Date());
    }

    public class MyLocalBinder extends Binder{
        MyService getBoundService(){
            return MyService.this;
        }
    }
}