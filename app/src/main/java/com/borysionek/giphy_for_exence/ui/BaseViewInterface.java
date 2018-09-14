package com.borysionek.giphy_for_exence.ui;

import android.view.View;

import com.borysionek.giphy_for_exence.models.GiphyResult;

public interface BaseViewInterface {

    void displayError(String errorMessage);

    void displayGifs(GiphyResult giphyResult);

    void showToast(String toast);

    void offlineTrigger();

    void newActivity();
}
