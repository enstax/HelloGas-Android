package com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.domain.presenter.gasolinera.comentarios.ComentariosGasPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.TabFragment;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios.adapter.ListComentarios;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ComentariosGasolinera extends TabFragment implements  ComentGasContract.View {

    private String idgasolinera;
    private ComentGasContract.Presenter presenter;

    // View
    @BindView(R.id.user_name) TextView tv_user;
    @BindView(R.id.fecha) TextView tv_fecha;
    @BindView(R.id.tv_comentario) TextView tv_comentario;
    @BindView(R.id.rating) RatingBar ratingBar;
    @BindView(R.id.b_thumb_up) ImageView iv_thhumb_up;
    @BindView(R.id.b_thumb_down) ImageView iv_thumb_down;
    @BindView(R.id.tv_like_count) TextView tv_likes;
    @BindView(R.id.tv_dislike_count) TextView tv_dislikes;
    @BindView(R.id.list_comentarios) ListView  listView;

    // Images
    @BindDrawable(R.drawable.ic_thumb_up_green) Drawable ic_like_green;
    @BindDrawable(R.drawable.ic_thumb_down_red) Drawable ic_dislike_red;
    @BindDrawable(R.drawable.ic_thumb_up) Drawable ic_like_gray;
    @BindDrawable(R.drawable.ic_thumb_down) Drawable ic_dislike_gray;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_gasolinera_comentarios, container, false);
        ButterKnife.bind(this, view);
        presenter = new ComentariosGasPresenter(getContext(), this);
        presenter.getComentarios(idgasolinera);
        return view;
    }

    public void setIdgasolinera(String idgasolinera) {
        this.idgasolinera = idgasolinera;
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        hideProgressDialog();
    }

    @Override
    public void loadList(ArrayList<Comentario> comentarios) {
        ListComentarios listComentarios = new ListComentarios(getContext(), comentarios);
        listView.setAdapter(listComentarios);
        hideProgressDialog();
    }

    @Override
    public void loadMComent(Comentario comentario) {
        hideProgressDialog();
    }

    @Override
    public void likeComent(Boolean b) {
        showProgressDialog();
    }

    @Override
    public void updateComent(String id) {

    }

    @Override
    public void loadComent(Comentario comentario) {

    }
}