package com.enstax.cesarcano.hellogas.ui.view.search;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface SearchContract {
    interface View extends BaseView {
        void loadPlaces(ArrayList<Gasolinera> gasolineras);
        void loadPlaceInfo(Gasolinera gasolinera);
    }

    interface Presenter extends BasePresenter<View> {
        void getPlacesInThisArea(Double latitud, Double longitud);
        void getPlaceInfo(String id);
    }
}