package com.borysionek.giphy_for_exence.ui.still;

import com.borysionek.giphy_for_exence.BuildConfig;
import com.borysionek.giphy_for_exence.models.GiphyResult;
import com.borysionek.giphy_for_exence.network.NetworkClient;
import com.borysionek.giphy_for_exence.network.NetworkInterface;
import com.borysionek.giphy_for_exence.ui.BasePresenterInterface;
import com.borysionek.giphy_for_exence.ui.BaseViewInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class StaticGifsPresenter implements BasePresenterInterface {

    private BaseViewInterface baseViewInterface;

    StaticGifsPresenter(BaseViewInterface baseViewInterface) {
        this.baseViewInterface = baseViewInterface;
    }

    //TODO ADD FILTERING ON
    void triggerFilterOn() {
    }
    // TODO ADD FILTERING OFF
    void triggerFilterOff() {
    }

    @Override
    public void getGifs() {
        getObservable().subscribeWith(getObserver());
    }

    private Observable<GiphyResult> getObservable() {
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .getGifs(BuildConfig.GIPHY_API_KEY, 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<GiphyResult> getObserver() {
        return new DisposableObserver<GiphyResult>() {

            @Override
            public void onNext(@NonNull GiphyResult giphyResult) {
                baseViewInterface.displayGifs(giphyResult);
            }

            @Override
            public void onError(@NonNull Throwable errorMessage) {
                errorMessage.printStackTrace();
                baseViewInterface.displayError("Error fetching Gif Data");
            }

            @Override
            public void onComplete() {
            }
        };
    }
}
