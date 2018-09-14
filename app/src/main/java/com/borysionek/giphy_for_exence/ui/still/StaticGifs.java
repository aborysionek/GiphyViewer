package com.borysionek.giphy_for_exence.ui.still;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.borysionek.giphy_for_exence.R;
import com.borysionek.giphy_for_exence.adapter.GifAdapter;
import com.borysionek.giphy_for_exence.models.GiphyResult;
import com.borysionek.giphy_for_exence.ui.BaseViewInterface;
import com.borysionek.giphy_for_exence.ui.moving.MovingGifs;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StaticGifs extends AppCompatActivity implements BaseViewInterface {

    @BindView(R.id.rvStatic)
    RecyclerView rvStatic;

    @BindView(R.id.buttonGoMoving)
    AppCompatButton button;

    @BindView(R.id.switchFavourites)
    SwitchCompat favouritesSwitch;

    private String TAG = "StaticGifs";

    RecyclerView.Adapter adapter;
    StaticGifsPresenter staticPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_gifs);
        ButterKnife.bind(this);

        setupMVP();
        setupViews();
        getGifs();
    }

    private void setupMVP() {
        staticPresenter = new StaticGifsPresenter(this);
    }

    private void setupViews() {
        rvStatic.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getGifs() {
        staticPresenter.getGifs();
    }

    @Override
    public void showToast(String message) {
        StyleableToast.makeText(this, message, R.style.normalToast).show();
    }

    @Override
    public void offlineTrigger() {
        //TODO FIX TRIGGER
        if (favouritesSwitch.isEnabled()) {
            staticPresenter.triggerFilterOn();
        }
        staticPresenter.triggerFilterOff();
        }

    @Override
    public void newActivity() {
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                startActivity(new Intent(StaticGifs.this, MovingGifs.class));
            }
        });
    }

    @Override
    public void displayGifs(GiphyResult giphyResult) {
        if (giphyResult != null) {
            adapter = new GifAdapter(giphyResult, StaticGifs.this);
            rvStatic.setAdapter(adapter);
        } else {
            Log.d(TAG, "Gifs response null");
        }
    }

    @Override
    public void displayError(String errorMessage) {
        StyleableToast.makeText(this, errorMessage, R.style.errorToast).show();
    }
}
