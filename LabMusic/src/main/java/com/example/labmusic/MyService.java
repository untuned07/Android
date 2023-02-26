package com.example.labmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mplayer;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        mplayer = MediaPlayer.create(this, R.raw.abc);
        mplayer.setLooping(false);
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(Intent intent, int startId){
        super.onStart(intent, startId);
        mplayer.start();
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mplayer.stop();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}