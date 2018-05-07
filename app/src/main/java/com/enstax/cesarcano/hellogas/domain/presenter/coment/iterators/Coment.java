package com.enstax.cesarcano.hellogas.domain.presenter.coment.iterators;


import com.enstax.cesarcano.hellogas.domain.model.Comentario;

/**
 * Created by cesarcanojmz@gmail.com
 */
public interface Coment {
    interface SetComentario {
        void update(Comentario comentario);
    }
    /*
    interface GetComentarios {
        void getComentarios(String gid);
    }

    interface Like {
        void setLike(String comentId); // Like/Dislike
    }

    interface Iterator{
        void getComentarios(ArrayList<Coment> comentarios);
        void getMComent(Coment comentario);
    }
    */
    interface Iterator{
        void response(int res, String msg);
    }
}
