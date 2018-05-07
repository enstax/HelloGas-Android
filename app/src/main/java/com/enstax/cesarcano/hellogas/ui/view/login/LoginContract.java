package com.enstax.cesarcano.hellogas.ui.view.login;

import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface LoginContract {

    interface View extends BaseView {
        void onLoginSucces();
        void onLoginError();
        void onValidFields(Boolean estado);
    }

    interface Presenter extends BasePresenter<LoginContract.View>{
        void performLogin(String username, String password);
    }
}