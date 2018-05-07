package com.enstax.cesarcano.hellogas.ui.view.coment;

import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface ComentarioContract {
    interface View extends BaseView{
        void response(String msj, int estado);
    }

    interface Presenter extends BasePresenter<ComentarioContract.View> {
        void enviarComentario(Comentario comentario, String gid);
    }
}
