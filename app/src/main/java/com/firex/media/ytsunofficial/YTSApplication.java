package com.firex.media.ytsunofficial;

import android.app.Application;

import com.firex.media.ytsunofficial.Utilities.sRequestQueue;

public class YTSApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        sRequestQueue.getInstance(this);
    }
}
