package com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface DetalleGasContract {
    interface View extends BaseView{
        void loadInfo(Gasolinera gasolinera);
        void heart(Boolean b);
    }

    interface Presenter extends BasePresenter<DetalleGasContract.View>{
        void getInfo(String id);
        void setFavorite(String gid);
    }
}
