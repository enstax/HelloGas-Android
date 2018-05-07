package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator;

import android.content.Context;
import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.GasolineraPresenter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class GetDetalleGas implements WebTask.Presenter, com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator.Gasolinera.Get  {


    private Context context;
    private com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator.Gasolinera.Iterator presenter;

    public GetDetalleGas(Context context, GasolineraPresenter presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            JSONObject place = jsonObject.getJSONObject("response");
            Log.d("GET DETALLE", "response: " + place.toString());
            Double latitud = place.getDouble("latitud");
            Double longitud = place.getDouble("longitud");
            String id = place.getString("id");
            String domicilio = place.getString("direccion");
            String marca = place.getString("marca");
            String nombre = place.getString("nombre");
            float calificacion = Float.valueOf(place.getString("calificacion"));
            com.enstax.cesarcano.hellogas.domain.model
                    .Gasolinera gasolinera = new com.enstax.cesarcano.hellogas.domain.model.
                    Gasolinera(id, marca, domicilio, calificacion, latitud, longitud, nombre);
            presenter.load(gasolinera);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInfo(String id) {
        final String url = "https://us-central1-hellogas-3db04.cloudfunctions.net/getgstation?id=" + id;
        Log.d("---> FAVORITOS PR", url);
        GApiTask task = new GApiTask(this, context);
        task.request(url);
    }
}
