package com.enstax.cesarcano.hellogas.ui.view.precios;

import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface PreciosContract {
    interface View extends BaseView {
        void loadPrecios(String regular, String premium, String diesel);
        void close();
    }

    interface Presenter extends BasePresenter<PreciosContract.View> {
        void getPrecios(String gig);
        void setPrecios(String regular, String premium, String diesel);
    }
}
