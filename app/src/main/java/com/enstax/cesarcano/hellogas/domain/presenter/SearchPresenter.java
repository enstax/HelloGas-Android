package com.enstax.cesarcano.hellogas.domain.presenter;

import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.data.local.GasolinerasTableTransaction;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.view.search.SearchContract;
import com.enstax.cesarcano.hellogas.ui.view.search.SearchFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SearchPresenter implements SearchContract.Presenter, WebTask.Presenter {

    private SearchContract.View view;

    private ArrayList<Gasolinera> gasolineras = new ArrayList<Gasolinera>();

    public SearchPresenter(SearchFragment searchFragment) {
        this.view = searchFragment;
    }

    @Override
    public void attachView(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPlacesInThisArea(Double lat, Double lng) {
        final String BASE_URL = "https://us-central1-hellogas-3db04.cloudfunctions.net/getgstations?";
        final String LAT = "lat=";
        final String LNG = "&lng=";
        view.loading();
        GApiTask gapi = new GApiTask(this, view.getContext());
        gapi.request(BASE_URL + LAT + lat + LNG + lng);
        Log.d("URL SEARCH", BASE_URL + LAT + lat + LNG + lng);
    }

    @Override
    public void getPlaceInfo(String id) {
        view.loading();
    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject place = jsonArray.getJSONObject(i);
                Double latitud = place.getDouble("latitud");
                Double longitud = place.getDouble("longitud");
                String id = place.getString("id");
                String domicilio = place.getString("direccion");
                String marca = place.getString("marca");
                String nombre = place.getString("nombre");
                int promo = place.getInt("promocion");
                float valoracion = Float.parseFloat(place.getString("calificacion"));
                Gasolinera gasolinera = new Gasolinera(id, marca, domicilio, latitud, longitud, nombre, valoracion, promo);

                gasolineras.add(gasolinera);
            }
            GasolinerasTableTransaction transaction = new GasolinerasTableTransaction(view.getContext());
            transaction.vaciarGasolineras();
            transaction.createGasolinera(gasolineras);
            view.loadPlaces(gasolineras);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}