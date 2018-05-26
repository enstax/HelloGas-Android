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
 * Created by cesar on 21/05/18.
 */

public class GetPrecios implements Gasolinera.GetPrecios, WebTask.Presenter {

    private Context context;
    private Gasolinera.Iterator iterator;

    public GetPrecios(Context context, Gasolinera.Iterator iterator) {
        this.context = context;
        this.iterator = iterator;
    }

    @Override
    public void getPrecios(String gid) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String url = " https://us-central1-hellogas-3db04.cloudfunctions.net/getprecios?gid=" + gid;
        Log.d("GET PRECIOS", url);
        GApiTask task = new GApiTask(this, context);
        task.request(url);
    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            JSONObject place = jsonObject.getJSONObject("response");
            Log.d("GET DETALLE", "response: " + place.toString());
            Double diesel = place.getDouble("diesel");
            Double premium = place.getDouble("premium");
            Double regular = place.getDouble("regular");

            iterator.loadPrecios(regular, premium, diesel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
