package com.enstax.cesarcano.hellogas.domain.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.enstax.cesarcano.hellogas.data.firebase.HgFirebaseDB;
import com.enstax.cesarcano.hellogas.ui.view.signup.SignUpContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SignUpPresenter implements SignUpContract.Presenter{

    private SignUpContract.View view;
    private FirebaseAuth mAuth;


    public SignUpPresenter(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    @Override
    public void registerPerform(final String name, final String email, String password1, String password2) {
        view.loading();
        if (isValidInfo(name, email, password1, password2)) {
            mAuth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener((Activity) view, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                HgFirebaseDB hgFirebaseDB = new HgFirebaseDB();
                                assert user != null;
                                hgFirebaseDB.createUser(user.getUid(), name, email);
                                // TODO DEVOLVER USUARIO PARA LOGIN
                                view.onRegisterSuccess();
                            } else {
                                view.onRegisterError();
                            }
                        }
                    });
        } else {
            view.onValidFields(false);
        }

    }


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

    private boolean isName(String name) {
        String REGEX_NAME =
                "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$";
        Pattern exp_name = Pattern.compile(REGEX_NAME);
        if (!name.isEmpty()) {
            if (exp_name.matcher(name).matches()) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidInfo(String name, String user, String password1, String passwor2) {
        return isName(name) && isEmail(user) && (password1.equals(passwor2));
    }

    @Override
    public void attachView(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
