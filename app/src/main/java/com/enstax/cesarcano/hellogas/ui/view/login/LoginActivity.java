package com.enstax.cesarcano.hellogas.ui.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.presenter.LogInPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseActivity;
import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;
import com.enstax.cesarcano.hellogas.ui.view.home.HomeActivity;
import com.enstax.cesarcano.hellogas.ui.view.signup.SignUpActivity;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.eT_user) EditText et_user;
    @BindView(R.id.eT_password) EditText et_password;
    @BindView(R.id.b_login) Button b_login;
    @BindView(R.id.b_flogin) Button b_fbLogin;
    @BindView(R.id.tv_crearCuenta) TextView tv_crearCuenta;
    @BindString(R.string.invalid_fields) String msg;
    @BindString(R.string.login_succes) String loginSucces;
    @BindString(R.string.login_error) String loginError;

    LoginContract.Presenter presenter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance() ;
        presenter = new LogInPresenter(mAuth);
        presenter.attachView(this);
    }

    @OnClick(R.id.b_login)
    public void login() {
        presenter.performLogin(
                et_user.getText().toString(),
                et_password.getText().toString()
        );
    }

    @OnClick(R.id.tv_crearCuenta)
    public void crearCuenta() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginSucces() {
        hideProgressDialog();
        Util.showMessage(this, loginSucces);
        this.finish();
        Util.setIntent(this, HomeActivity.class);
    }

    @Override
    public void onLoginError() {
        Util.showMessage(this, loginError);
        cleanFields();
        hideProgressDialog();
    }

    @Override
    public void onValidFields(Boolean estado) {
        if(!estado)
            Util.showMessage(this, msg);
        hideProgressDialog();
        cleanFields();
    }

    // LIMPIAR CAMPOS
    private void cleanFields() {
        et_password.setText("");
        et_user.setText("");
    }

    /* <!-- MENU --> */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.exit: // Termina la app
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {

    }
    /* <--- MENU --->*/

}