package com.enstax.cesarcano.hellogas.domain.presenter;

import android.content.Context;

import com.enstax.cesarcano.hellogas.ui.view.precios.PreciosActivity;
import com.enstax.cesarcano.hellogas.ui.view.precios.PreciosContract;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class PreciosPresenter implements PreciosContract.Presenter {

    private Context context;
    private PreciosContract.View view;

    public PreciosPresenter(Context context, PreciosActivity view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void attachView(PreciosContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPrecios(String gig) {

    }

    @Override
    public void setPrecios(String regular, String premium, String diesel) {
        view.loadPrecios(regular, premium, diesel);
    }
}
