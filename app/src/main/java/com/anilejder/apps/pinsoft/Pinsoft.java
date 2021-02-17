package com.anilejder.apps.pinsoft;

import android.app.Application;
import android.content.Context;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:51
 */
public class Pinsoft extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
