package com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Comentario;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ListComentarios extends BaseAdapter {
    private ArrayList<Comentario> comentarios = new ArrayList<>();
    private LayoutInflater layoutInflater;

    // View
    @BindView(R.id.user_name) TextView tv_user;
    @BindView(R.id.fecha) TextView tv_fecha;
    @BindView(R.id.tv_comentario) TextView tv_comentario;
    @BindView(R.id.rating) RatingBar ratingBar;
    @BindView(R.id.b_thumb_up) ImageView iv_thhumb_up;
    @BindView(R.id.b_thumb_down) ImageView iv_thumb_down;
    @BindView(R.id.tv_like_count) TextView tv_likes;
    @BindView(R.id.tv_dislike_count) TextView tv_dislikes;

    // Images
    @BindDrawable(R.drawable.ic_thumb_up_green) Drawable ic_like_green;
    @BindDrawable(R.drawable.ic_thumb_down_red) Drawable ic_dislike_red;
    @BindDrawable(R.drawable.ic_thumb_up) Drawable ic_like_gray;
    @BindDrawable(R.drawable.ic_thumb_down) Drawable ic_dislike_gray;


    public ListComentarios(Context context, ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return comentarios.size();
    }

    @Override
    public Object getItem(int position) {
        return comentarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void clear() {
        comentarios.clear();
    }

    public void addAll(ArrayList<Comentario> comentarios) {
        this.comentarios.addAll(comentarios);
    }


    @Override
    public View getView(int position, View row_view, ViewGroup parent) {
        Comentario comentario = comentarios.get(position);
        if (row_view == null) {
            row_view = layoutInflater.inflate(R.layout.item_gas_comentario, null);
        }
        ButterKnife.bind(this, row_view);

        tv_comentario.setText(comentario.getComentario());
        tv_user.setText(comentario.getUsuario());
        tv_fecha.setText(comentario.getFecha_creacion());
        tv_dislikes.setText(comentario.getDislikes());
        tv_likes.setText(comentario.getLikes());
        ratingBar.setRating(comentario.getCalificacion());
        if ( comentario.getLikes() > 0) {
            iv_thhumb_up.setImageDrawable(ic_like_green);
        } else {
            iv_thhumb_up.setImageDrawable(ic_like_gray);
        }
        if ( comentario.getDislikes() > 0) {
            iv_thumb_down.setImageDrawable(ic_dislike_red);
        } else {
            iv_thumb_down.setImageDrawable(ic_dislike_gray);
        }

        return row_view;
    }
}
