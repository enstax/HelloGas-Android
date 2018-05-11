package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.iterator;

import android.content.Context;
import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.ComentariosGasPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class GetAllComent implements WebTask.Presenter, Coment.Get {

    private Coment.Iterator iterator;
    private Context context;

    public GetAllComent(ComentariosGasPresenter iterator, Context context) {
        this.iterator = iterator;
        this.context = context;
    }

    @Override
    public void getAll(String gid) {
        final String url = "https://us-central1-hellogas-3db04.cloudfunctions.net/getcomentarios?gid="+gid;
        Log.d("CARGANDO COMENTS", url);
        GApiTask task = new GApiTask(this, context);
        task.request(url);
    }

    @Override
    public void response(JSONObject jsonObject) {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            if (jsonArray.length() > 0 ) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject place = jsonArray.getJSONObject(i);
                    float calificacion = Float.parseFloat(place.getString("calificacion"));
                    int dislikes = place.getInt("dislikes");
                    int likes = place.getInt("likes");
                    String texto = place.getString("texto");
                    String fecha = place.getString("fecha");
                    String uid = place.getString("uid");
                    String uNombre = place.getString("user");
                    String gid = place.getString("gid");
                    String idC = place.getString("id");

                    if (texto.equals("0")) {
                        texto = "";
                    }

                    Comentario  comentario = new Comentario(idC, gid, uNombre, uid, calificacion, dislikes, likes, fecha, texto);

                    if(uid.equals(user.getUid())) {
                        iterator.updateMComent(comentario);
                    } else {
                        comentarios.add(comentario);
                    }
                }
                iterator.loadComentarios(comentarios);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
