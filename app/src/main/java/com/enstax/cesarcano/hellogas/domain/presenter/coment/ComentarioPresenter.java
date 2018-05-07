package com.enstax.cesarcano.hellogas.domain.presenter.coment;

import android.content.Context;

import com.enstax.cesarcano.hellogas.domain.presenter.coment.iterators.Coment;
import com.enstax.cesarcano.hellogas.domain.presenter.coment.iterators.SetMComentario;
import com.enstax.cesarcano.hellogas.ui.view.coment.ComentarioActivity;
import com.enstax.cesarcano.hellogas.ui.view.coment.ComentarioContract;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ComentarioPresenter implements Coment.Iterator, ComentarioContract.Presenter{

    private Context context;
    private ComentarioContract.View view;
    private Coment.SetComentario setComentario;

    public ComentarioPresenter(Context context, ComentarioActivity view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void attachView(ComentarioContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void enviarComentario(com.enstax.cesarcano.hellogas.domain.model.Comentario coment, String gid) {
        view.loading();
        setComentario = new SetMComentario(context, this);
        setComentario.update(coment);
    }

    @Override
    public void response(int res, String msg) {
        if (res == 200) {
            view.response(msg, res);
        }
    }
}
