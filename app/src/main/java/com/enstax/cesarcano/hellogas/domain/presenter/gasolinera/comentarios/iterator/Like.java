package com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.iterator;

import com.enstax.cesarcano.hellogas.data.api.WebTask;

import org.json.JSONObject;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Like implements WebTask.Presenter, Coment.SetLike {

    @Override
    public void response(JSONObject jsonObject) {

    }

    @Override
    public void setLike(String comentId) {

    }

    @Override
    public void setDisLike(String comentId) {

    }
}
