package com.enstax.cesarcano.hellogas.domain.presenter.favoritos.iterators;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */


public interface Favoritos {
    interface Get {
        void getAll();
    }

    interface Iterator {
        void load(ArrayList<Gasolinera> gasolineras);
    }
}
