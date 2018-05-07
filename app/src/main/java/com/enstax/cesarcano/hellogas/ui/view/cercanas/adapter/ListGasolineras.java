package com.enstax.cesarcano.hellogas.ui.view.cercanas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ListGasolineras extends BaseAdapter {
    private LayoutInflater layoutInflater;
    protected ArrayList<Gasolinera> gasolineras;

    @BindView(R.id.tv_ultimoprecio) TextView tv_ultimoPrecio;
    @BindView(R.id.tv_nombre) TextView tv_nombre;
    @BindView(R.id.tv_direccion) TextView tv_direccion;
    @BindView(R.id.tv_distancia) TextView tv_distancia;
    @BindView(R.id.tv_tiempo) TextView tv_ultimaAct;
    @BindView(R.id.rating_lugar) RatingBar rb_rating;

    public ListGasolineras(Context context, ArrayList<Gasolinera> gasolineras) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.gasolineras = gasolineras;
    }

    @Override
    public int getCount() {
        return gasolineras.size();
    }

    @Override
    public Object getItem(int position) {
        return gasolineras.get(position);
    }

    public void clear() {
        gasolineras.clear();
    }

    public void addAll(ArrayList<Gasolinera> gasolineras) {
        this.gasolineras.addAll(gasolineras);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View row_view, ViewGroup parent) {
        Gasolinera gasolinera = gasolineras.get(position);
        if (row_view == null) {
            row_view = layoutInflater.inflate(R.layout.item_gasolinera, null);
        }
        ButterKnife.bind(this, row_view);
        tv_ultimoPrecio.setText("NULL");
        tv_nombre.setText(gasolinera.getMarca());
        tv_direccion.setText(gasolinera.getDomicilio());

        /*
        if (Gasolineras.posicionActual != null && gasolinera.getPosicion() != null) {
            int distancia = (int) Gasolineras.posicionActual.getDistancia(gasolinera.getPosicion());
            if (distancia < 1999) {
                tv_distancia.setText(distancia + " m");
            } else {
                tv_distancia.setText(distancia / 1000 + " Km");
            }
        }
        */
        tv_distancia.setText("8 Km");
        tv_ultimaAct.setText("hoy");
        rb_rating.setRating(gasolinera.getValoracion());

        return row_view;
    }
}