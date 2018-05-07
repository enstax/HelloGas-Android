package com.enstax.cesarcano.hellogas.ui.view.signup;

import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface SignUpContract {
    interface View extends BaseView{
        void onRegisterSuccess();
        void onRegisterError();
        void onValidFields(Boolean estado);
        void error();
    }
    interface Presenter extends BasePresenter<SignUpContract.View>{
        void registerPerform(String name, String email, String password1, String password2);
    }
}