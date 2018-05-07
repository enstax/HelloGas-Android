package com.enstax.cesarcano.hellogas.ui.view.signup;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.presenter.SignUpPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseActivity;
import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;
import com.enstax.cesarcano.hellogas.ui.view.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SignUpActivity extends BaseActivity implements SignUpContract.View {

    private static final String TAG = "REGISTRO DE USUARIO";
    @BindView(R.id.eT_nombre)
    EditText et_nombre;
    @BindView(R.id.eT_email)
    EditText et_correo;
    @BindView(R.id.eT_password)
    EditText et_password1;
    @BindView(R.id.eT_password2)
    EditText et_password2;
    @BindView(R.id.b_cancelar)
    Button b_cancelReg;
    @BindView(R.id.b_crearCuenta)
    Button b_registrar;

    @BindString(R.string.signin_succes) String signinSuccess;
    @BindString(R.string.signin_error) String signinError;
    @BindString(R.string.invalid_fields) String msg;

    private SignUpContract.Presenter presenter;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance() ;
        presenter = new SignUpPresenter(mAuth);
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @OnClick(R.id.b_crearCuenta)
    public void signUp() {
        showProgressDialog();
        String name = et_nombre.getText().toString();
        String email = et_correo.getText().toString();
        String pass1 = et_password1.getText().toString();
        String pass2 = et_password2.getText().toString();
        presenter.registerPerform(name, email, pass1, pass2);
    }

    @OnClick(R.id.b_cancelar)
    public void cancelar() {
        this.finish();
    }
    /* <!--- VALIDACIONES --- */

    private void cleanFields() {
        et_nombre.setText("");
        et_correo.setText("");
        et_password1.setText("");
        et_password2.setText("");
    }

    @Override
    public void onRegisterSuccess() {
        Util.showMessage(this, signinSuccess);
        hideProgressDialog();
        this.finish();
        Util.setIntent(this, HomeActivity.class);
    }

    @Override
    public void onRegisterError() {
        Util.showMessage(this, signinError);
        hideProgressDialog();
        cleanFields();
    }

    @Override
    public void onValidFields(Boolean estado) {
        if(!estado)
            Util.showMessage(this, msg);
        hideProgressDialog();
        cleanFields();
    }

    @Override
    public void error() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loading() {
        showProgressDialog();
    }
}