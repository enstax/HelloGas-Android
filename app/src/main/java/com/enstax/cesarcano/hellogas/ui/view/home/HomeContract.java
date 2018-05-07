package com.enstax.cesarcano.hellogas.ui.view.home;

import com.enstax.cesarcano.hellogas.ui.helper.base.BasePresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface HomeContract {
    interface View extends BaseView {
        void setEnabled(boolean isEnabled);
        void setUser(FirebaseUser user);

    }

    interface Presenter extends BasePresenter<HomeContract.View> {
        void getCurrentUser();
        void signOut();
        void onStart();
        void onStop();
    }
}