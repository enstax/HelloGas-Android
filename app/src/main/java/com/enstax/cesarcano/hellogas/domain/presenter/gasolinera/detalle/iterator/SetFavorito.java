package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator;


import android.content.Context;
import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SetFavorito implements com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator.Gasolinera.SetFavorito, WebTask.Presenter {

    private Context context;
    private com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator.Gasolinera.Iterator presenter;

    public SetFavorito(Context context, com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.detalle.iterator.Gasolinera.Iterator presenter) {
        this.context = context;
        this.presenter = presenter;
    }

    @Override
    public void setFavorito(String gid) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String url = " https://us-central1-hellogas-3db04.cloudfunctions.net/setfavorito?uid=" +
                user.getUid() + "&id=" + gid;
                ;
        Log.d("Agregar a Favoritos", url);
        GApiTask task = new GApiTask(this, context);
        task.request(url);
    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            Boolean message = jsonObject.getBoolean("message");
            presenter.favorite(message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
