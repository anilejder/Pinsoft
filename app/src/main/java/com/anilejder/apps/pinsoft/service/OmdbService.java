package com.anilejder.apps.pinsoft.service;

import com.anilejder.apps.pinsoft.Pinsoft;
import com.anilejder.apps.pinsoft.R;
import com.anilejder.apps.pinsoft.constant.ApiConstants;
import com.anilejder.apps.pinsoft.model.request.FilmRequestModel;
import com.anilejder.apps.pinsoft.model.response.FilmResponseModel;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:49
 */
public class OmdbService {

    private OmdbApi mOmdbApi;
    private final String mServiceBase = Pinsoft.getContext().getString(R.string.omdb_api_base);

    public OmdbService() {
        mOmdbApi = new Retrofit.Builder()
                .baseUrl(mServiceBase)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(OmdbApi.class);
    }

    public Single<FilmResponseModel> searchFilm(FilmRequestModel filmRequestModel) {
        return mOmdbApi.searchFilm(filmRequestModel.getTitle(),
                ApiConstants.PLOT_FULL, Pinsoft.getContext().getString(R.string.omdb_api_key));
    }
}