package com.enstax.cesarcano.hellogas.domain.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.enstax.cesarcano.hellogas.ui.helper.base.BaseView;
import com.enstax.cesarcano.hellogas.ui.view.login.LoginContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class LogInPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private FirebaseAuth mAuth;

    public LogInPresenter(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @Override
    public void performLogin(String email, String password) {
        view.loading();
        if (!isValidInfo(email, password)) {
            view.onValidFields(false);
        } else {
            // EXECUTA EL LOGIN
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener((Activity) view, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                view.onLoginError();
                            } else {
                                view.onLoginSucces();
                            }
                        }
                    });
        }
    }

    /* <!--- VALIDACIONES --- */
    private boolean isEmail(String email) {
        String REGEX_EMAIL = "^([a-zA-Z0-9\\._-])+\\@(([a-zA-Z0-9-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        Pattern exp_email = Pattern.compile(REGEX_EMAIL);
        if (!email.isEmpty()) {
            if (exp_email.matcher(email).matches()) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidInfo(String email, String password) {
        return isEmail(email) && (!password.isEmpty());
    }

    @Override
    public void attachView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    /* --- VALIDACIONES --- >*/
}