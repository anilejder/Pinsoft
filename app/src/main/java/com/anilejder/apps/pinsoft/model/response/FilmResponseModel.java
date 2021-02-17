package com.anilejder.apps.pinsoft.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;

/**
 * User: Anıl Ejder
 * Date: 17/02/2021
 * Time: 21:29
 */
@Data
@Builder
public class FilmResponseModel {

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Year")
    @Expose
    private String year;

    @SerializedName("Genre")
    @Expose
    private String genre;

    @SerializedName("Director")
    @Expose
    private String director;

    @SerializedName("Writer")
    @Expose
    private String writer;

    @SerializedName("Actors")
    @Expose
    private String actors;

    @SerializedName("Plot")
    @Expose
    private String plot;

    @SerializedName("Poster")
    @Expose
    private String posterUrl;

    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;

}
