package com.anilejder.apps.pinsoft.helper;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 22:19
 */
public class AppSchedulerProvider implements SchedulerProvider {

    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
