package com.enstax.cesarcano.hellogas.ui.view.cercanas;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface CercanasContract{
    interface View extends BaseView{
        void loadList(ArrayList<Gasolinera> gasolineras);
    }

    interface Presenter extends BasePresenter<CercanasContract.View> {
        void loadByDistance();
        void loadByPromo();
        void loadByValoration();
        void loadByPrice();
    }
}