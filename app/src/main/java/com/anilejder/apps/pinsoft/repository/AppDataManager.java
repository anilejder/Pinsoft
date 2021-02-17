package com.anilejder.apps.pinsoft.repository;

import com.anilejder.apps.pinsoft.model.request.FilmRequestModel;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;
import com.anilejder.apps.pinsoft.repository.remote.AppOmdbManager;
import com.anilejder.apps.pinsoft.repository.remote.OmdbManager;

import io.reactivex.Single;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:19
 */
public class AppDataManager implements DataManager {

    private final OmdbManager mOmdbManager;

    public AppDataManager() {
        mOmdbManager = new AppOmdbManager();
    }

    @Override
    public Single<FilmResponseModel> searchWith(FilmRequestModel filmRequestModel) {
        return mOmdbManager.searchWith(filmRequestModel);
    }
}
