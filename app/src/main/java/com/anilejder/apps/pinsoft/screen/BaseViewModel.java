package com.anilejder.apps.pinsoft.screen;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.anilejder.apps.pinsoft.helper.AppSchedulerProvider;
import com.anilejder.apps.pinsoft.helper.SchedulerProvider;
import com.anilejder.apps.pinsoft.repository.AppDataManager;

import io.reactivex.disposables.CompositeDisposable;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 22:10
 */
public class BaseViewModel extends AndroidViewModel {

    private SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mCompositeDisposable;
    private AppDataManager mAppDataManager;

    private MutableLiveData<Boolean> mLoading = new MutableLiveData<>();
    private MutableLiveData<String> mError = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mSchedulerProvider = new AppSchedulerProvider();
        mCompositeDisposable = new CompositeDisposable();
        mAppDataManager = new AppDataManager();
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public AppDataManager getAppDataManager() {
        return mAppDataManager;
    }

    public MutableLiveData<Boolean> getLoading() {
        return mLoading;
    }

    public MutableLiveData<String> getError() {
        return mError;
    }
}