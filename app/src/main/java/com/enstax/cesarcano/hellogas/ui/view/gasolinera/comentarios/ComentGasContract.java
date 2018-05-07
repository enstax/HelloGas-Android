package com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios;

import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

import java.util.ArrayList;


/**
 * Created by cesarcanojmz@gmail.com
 */

public interface ComentGasContract {
    interface View extends BaseView {
        void loadList(ArrayList<Comentario> comentarios);
        void loadMComent(Comentario comentario);
        void likeComent(Boolean b);
        void updateComent(String id);
        void loadComent(Comentario comentario);
    }

    interface Presenter extends BasePresenter<ComentGasContract.View> {
        void getComentarios(String gid);
        void likeIt(String gid);
        void coment(String id);
        void mComent(String uid);
    }
}
