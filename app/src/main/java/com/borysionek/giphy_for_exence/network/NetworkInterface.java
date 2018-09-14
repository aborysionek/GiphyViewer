package com.borysionek.giphy_for_exence.network;

import com.borysionek.giphy_for_exence.models.GiphyResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("trending")
    Observable<GiphyResult> getGifs(
            @Query("api_key") String api_key,
            @Query("offset") Integer offset
    );
}