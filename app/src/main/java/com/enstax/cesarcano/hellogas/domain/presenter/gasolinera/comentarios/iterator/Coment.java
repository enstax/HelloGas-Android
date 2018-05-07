package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.iterator;

import com.enstax.cesarcano.hellogas.domain.model.Comentario;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface Coment {
    interface SetLike {
        void setLike(String comentId);
        void setDisLike(String comentId);
    }

    interface Get{
        void getAll();
    }

    interface Update {
        void updateMComent();
    }

    interface Iterator{
        void updateLike(Boolean b);
        void loadComentarios(ArrayList<Comentario> comentarios);
        void updateMComent(Comentario comentario);
        void updateComent(Comentario comentario);
    }
}
