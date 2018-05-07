package com.enstax.cesarcano.hellogas.ui.view.favoritos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ListFavoritos extends BaseAdapter {
    private LayoutInflater layoutInflater;
    protected ArrayList<Gasolinera> gasolineras;
    private TextView tv_nombre;
    private TextView tv_direccion;
    private TextView tv_distancia;
    private ImageView iv_favorito;

    public ListFavoritos(Context context, ArrayList<Gasolinera> gasolineras) {
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
        final Gasolinera gasolinera = gasolineras.get(position);
        if (row_view == null) {
            row_view = layoutInflater.inflate(R.layout.item_favorito, null);
        }

        tv_nombre = row_view.findViewById(R.id.fav_marca);
        tv_direccion = row_view.findViewById(R.id.fav_direccion);
        tv_distancia = row_view.findViewById(R.id.fav_distancia);
        iv_favorito = row_view.findViewById(R.id.fav_icfavorite);

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
        return row_view;
    }
}