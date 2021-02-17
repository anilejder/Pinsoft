package com.anilejder.apps.pinsoft.repository.remote;

import com.anilejder.apps.pinsoft.model.request.FilmRequestModel;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;
import com.anilejder.apps.pinsoft.service.OmdbService;

import io.reactivex.Single;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:20
 */
public class AppOmdbManager implements OmdbManager {

    private final OmdbService mOmdbService;

    public AppOmdbManager() {
        mOmdbService = new OmdbService();
    }

    @Override
    public Single<FilmResponseModel> searchWith(FilmRequestModel filmRequestModel) {
        return mOmdbService.searchFilm(filmRequestModel);
    }
}