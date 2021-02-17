package com.anilejder.apps.pinsoft.screen.film;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.anilejder.apps.pinsoft.model.request.FilmRequestModel;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;
import com.anilejder.apps.pinsoft.screen.BaseViewModel;

import io.reactivex.disposables.Disposable;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 22:08
 */
public class FilmViewModel extends BaseViewModel {

    private final MutableLiveData<FilmResponseModel> mFilmObservable = new MutableLiveData<>();

    public FilmViewModel(@NonNull Application application) {
        super(application);
    }

    public void searchFilmWith(String title) {

        getLoading().setValue(true);

        FilmRequestModel filmRequestModel = FilmRequestModel.builder().title(title).build();

        Disposable disposable = getAppDataManager().searchWith(filmRequestModel)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(filmResponseModel -> {

                    getLoading().setValue(false);
                    mFilmObservable.setValue(filmResponseModel);

                }, throwable -> {
                    getLoading().setValue(false);
                    getError().setValue(throwable.getMessage());
                });

        getCompositeDisposable().add(disposable);
    }

    public MutableLiveData<FilmResponseModel> getFilmObservable() {
        return mFilmObservable;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getCompositeDisposable().dispose();
    }
}