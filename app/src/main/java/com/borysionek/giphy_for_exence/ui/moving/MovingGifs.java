package com.borysionek.giphy_for_exence.ui.moving;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.borysionek.giphy_for_exence.R;
import com.borysionek.giphy_for_exence.models.GiphyResult;
import com.borysionek.giphy_for_exence.ui.BaseViewInterface;

public class MovingGifs extends AppCompatActivity implements BaseViewInterface {

    @Override
    public void displayError(final String errorMessage) {

    }

    @Override
    public void displayGifs(final GiphyResult giphyResult) {

    }

    @Override
    public void showToast(final String toast) {

    }

    @Override
    public void offlineTrigger() {

    }

    @Override
    public void newActivity() {

    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_moving_gifs);
        }
    }
