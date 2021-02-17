package com.anilejder.apps.pinsoft.model.request;

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
public class FilmRequestModel {

    @SerializedName("Title")
    @Expose
    private String title;
}