package com.enstax.cesarcano.hellogas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PreciosActivity extends AppCompatActivity {

    @BindView(R.id.eT_gasRegular) EditText eT_regular;
    @BindView(R.id.eT_gasPremium) EditText eT_premium;
    @BindView(R.id.eT_gasDiesel) EditText eT_diesel;
    @BindView(R.id.b_enviar) Button b_enviar;
    @BindView(R.id.b_cancelar) Button b_cancelar;
    @BindView(R.id.iV_edit_regular)ImageView iV_edit_regular;
    @BindView(R.id.iV_edit_premium) ImageView iV_edit_premium;
    @BindView(R.id.iV_edit_diesel) ImageView iV_edit_diesel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precios);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iV_edit_regular)
    public void editGAsRegular() {
        estadoCampo(eT_regular);
    }

    @OnClick(R.id.iV_edit_premium)
    public void editGasPremium() {
        estadoCampo(eT_premium);
    }
    @OnClick(R.id.iV_edit_diesel)
    public void editGasDiesel() {
        estadoCampo(eT_diesel);
    }

    @OnClick(R.id.b_enviar)
    public void enviar() {

    }
    @OnClick(R.id.b_cancelar)
    public void cancelar() {
        this.finish();
    }

    private void estadoCampo(EditText textField) {
        if(textField.isEnabled()) {
            textField.setEnabled(false);
        } else {
            textField.setEnabled(true);
            textField.requestFocus();
        }
    }
}
