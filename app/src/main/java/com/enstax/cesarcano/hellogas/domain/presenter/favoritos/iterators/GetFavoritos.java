package com.enstax.cesarcano.hellogas.domain.presenter.favoritos.iterators;

import android.content.Context;
import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.favoritos.FavoritosPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class GetFavoritos implements Favoritos.Get, WebTask.Presenter {

    private Favoritos.Iterator presenter;
    private FirebaseUser user;
    private Context context;

    public GetFavoritos(FavoritosPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public void getAll() {
        final String url = "https://us-central1-hellogas-3db04.cloudfunctions.net/getfavoritos?id=" + user.getUid();
        Log.d("---> FAVORITOS PR", url);
        GApiTask task = new GApiTask(this, context);
        task.request(url);
    }

    @Override
    public void response(JSONObject jsonObject) {

        ArrayList<Gasolinera> gasolineras = new ArrayList<Gasolinera>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            Log.d("GET FAVORITOS", "response: " + jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject place = jsonArray.getJSONObject(i);
                Double latitud = place.getDouble("lat");
                Double longitud = place.getDouble("lng");
                String id = place.getString("id");
                String domicilio = place.getString("direccion");
                String marca = place.getString("marca");
                Gasolinera gasolinera = new Gasolinera(id, marca, domicilio, latitud, longitud);
                gasolineras.add(gasolinera);
            }

            presenter.load(gasolineras);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
