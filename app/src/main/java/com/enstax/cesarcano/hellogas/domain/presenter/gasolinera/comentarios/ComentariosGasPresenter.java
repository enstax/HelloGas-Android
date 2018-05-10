package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios;

import android.content.Context;

import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.iterator.Coment;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.iterator.GetAllComent;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios.ComentGasContract;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios.ComentariosGasolinera;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ComentariosGasPresenter implements ComentGasContract.Presenter, Coment.Iterator{

    private Context context;
    private ComentGasContract.View view;
    private Coment.Get getComent;

    public ComentariosGasPresenter(Context context, ComentariosGasolinera view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void attachView(ComentGasContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getComentarios(String gid) {
        view.loading();
        getComent = new GetAllComent(this, context);
        getComent.getAll(gid);
    }

    @Override
    public void likeIt(String gid) {

    }

    @Override
    public void coment(String id) {

    }

    @Override
    public void mComent(String uid) {

    }

    @Override
    public void updateLike(Boolean b) {

    }

    @Override
    public void loadComentarios(ArrayList<Comentario> comentarios) {
        view.loadList(comentarios);
    }

    @Override
    public void updateMComent(Comentario comentario) {
        view.loadMComent(comentario);
    }

    @Override
    public void updateComent(Comentario comentario) {

    }
}
