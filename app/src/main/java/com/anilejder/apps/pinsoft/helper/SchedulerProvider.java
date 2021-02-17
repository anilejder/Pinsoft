package com.anilejder.apps.pinsoft.helper;

import io.reactivex.Scheduler;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 22:16
 */
public interface SchedulerProvider {

    Scheduler io();

    Scheduler ui();
}
