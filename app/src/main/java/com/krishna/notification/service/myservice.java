package com.krishna.notification.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myservice extends Service {
    public Context context =this;
    public Handler handler =null;
    public Runnable runnable=null;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Services Created", Toast.LENGTH_SHORT).show();
        handler =new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                double randomNo =getRandomDoubleBetweenRange(1,100);
                Toast.makeText(context, "Random no", Toast.LENGTH_SHORT).show();

                handler.postDelayed(runnable,
                        2000);
            }
        };
        handler.postDelayed(runnable,2000);
    }

    private double getRandomDoubleBetweenRange(int i, int i1) {
        return (Math.random()*((i-i1)+1))+i1;


    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Services Stopped", Toast.LENGTH_SHORT).show();
    }
}
