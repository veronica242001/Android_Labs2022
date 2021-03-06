package com.example.myapp.lab4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.myapp.lab4.TickListener;


public class ClockBroadcast extends BroadcastReceiver {

    TickListener listener;

    void setupListener(TickListener listener){
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_TIME_TICK) && listener!=null)
            listener.tick();
    }
}