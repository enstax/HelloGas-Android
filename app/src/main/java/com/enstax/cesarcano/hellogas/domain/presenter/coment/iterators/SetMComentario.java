package com.enstax.cesarcano.hellogas.domain.presenter.coment.iterators;

import android.content.Context;
import android.util.Log;

import com.enstax.cesarcano.hellogas.data.api.GApiTask;
import com.enstax.cesarcano.hellogas.data.api.WebTask;
import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.domain.presenter.coment.ComentarioPresenter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SetMComentario implements Coment.SetComentario, WebTask.Presenter {

    private Context context;
    private Coment.Iterator iterator;
    private Comentario comentario;

    public SetMComentario(Context context, ComentarioPresenter iterator) {
        this.context = context;
        this.iterator = iterator;
    }

    @Override
    public void response(JSONObject jsonObject) {
        try {
            int status = jsonObject.getInt("status");
            if(status != 200) {
                this.update(comentario);
            } else {
                String msg = jsonObject.getString("message");
                iterator.response(status, msg);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Comentario comentario) {
        this.comentario = comentario;
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String url = "https://us-central1-hellogas-3db04.cloudfunctions.net/addcomment?texto=" +
                comentario.getComentario() +
                "&uid=" + user.getUid() +
                "&gid=" + comentario.getItem_id() + "&rank=" + comentario.getCalificacion();
        Log.d("---> SET COMENTARIO PR", url);
        GApiTask task = new GApiTask(this, context);
        task.request(url);
    }
}
