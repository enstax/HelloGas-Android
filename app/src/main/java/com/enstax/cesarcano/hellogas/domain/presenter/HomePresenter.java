package com.enstax.cesarcano.hellogas.domain.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;
import com.enstax.cesarcano.hellogas.ui.view.home.HomeContract;
import com.enstax.cesarcano.hellogas.ui.view.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class HomePresenter implements HomeContract.Presenter {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;

    private HomeContract.View homeView;
    private Activity context;

    public HomePresenter(FirebaseAuth auth, final Activity context) {
        this.auth = auth;
        this.context = context;

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user == null) {
                    Util.setIntent(context, LoginActivity.class);
                    context.finish();
                }
            }
        };
    }

    @Override
    public void attachView(HomeContract.View view) {
        this.homeView = view;
    }

    @Override
    public void detachView() {
        this.homeView = null;
    }

    @Override
    public void getCurrentUser() {
        if (auth.getCurrentUser() != null)
            homeView.setUser(auth.getCurrentUser());
    }

    @Override
    public void signOut() {
        auth.signOut();
    }

    @Override
    public void onStart() {
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        auth.removeAuthStateListener(authStateListener);
    }
}