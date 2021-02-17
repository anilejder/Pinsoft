package com.anilejder.apps.pinsoft.service;

import com.anilejder.apps.pinsoft.constant.ApiConstants;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:42
 */
public interface OmdbApi {

    @GET(".")
    Single<FilmResponseModel> searchFilm(@Query(ApiConstants.TITLE) String title,
                                         @Query(ApiConstants.PLOT) String plot,
                                         @Query(ApiConstants.API_KEY) String apiKey);
}
