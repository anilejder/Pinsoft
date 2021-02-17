package com.anilejder.apps.pinsoft.repository.remote;

import com.anilejder.apps.pinsoft.model.request.FilmRequestModel;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;

import io.reactivex.Single;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:20
 */
public interface OmdbManager {

    Single<FilmResponseModel> searchWith(FilmRequestModel filmRequestModel);
}
