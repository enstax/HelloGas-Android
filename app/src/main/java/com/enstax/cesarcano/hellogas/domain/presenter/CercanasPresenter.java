package com.enstax.cesarcano.hellogas.domain.presenter;

import android.database.Cursor;

import com.enstax.cesarcano.hellogas.data.local.GasolinerasTableTransaction;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.model.Geopunto;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.CercanasContract;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.CercanasFragment;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class CercanasPresenter implements CercanasContract.Presenter {
    private FirebaseAuth.AuthStateListener authStateListener;
    private CercanasContract.View cercanasView;

    public CercanasPresenter(CercanasFragment cercanasFragment) {
        this.cercanasView = cercanasFragment;
    }

    @Override
    public void attachView(CercanasContract.View view) {
        this.cercanasView = view;
    }

    @Override
    public void detachView() {
        this.cercanasView = null;
    }

    @Override
    public void loadByDistance() {

    }

    @Override
    public void loadByPromo() {

    }

    @Override
    public void loadByValoration() {

    }

    @Override
    public void loadByPrice() {
        cercanasView.loading();
        ArrayList<Gasolinera> gasolineras = new ArrayList<Gasolinera>();
        GasolinerasTableTransaction db = new GasolinerasTableTransaction(cercanasView.getContext());
        Cursor g = db.getGasolinerasByPrecio();
        for (g.moveToFirst(); !g.isAfterLast(); g.moveToNext()) {
            Gasolinera gas = new Gasolinera(
                    g.getString(0),
                    g.getString(1),
                    g.getString(2),
                    g.getDouble(4),
                    g.getDouble(5),
                    g.getString(6),
                    g.getFloat(3),
                    g.getInt(7)
            );
            gasolineras.add(gas);
        }
        cercanasView.loadList(gasolineras);
    }
}