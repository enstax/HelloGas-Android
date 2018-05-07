package com.enstax.cesarcano.hellogas.ui.view.coment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Comentario;
import com.enstax.cesarcano.hellogas.domain.presenter.coment.ComentarioPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseActivity;
import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class ComentarioActivity extends BaseActivity implements ComentarioContract.View {

    @BindView(R.id.tv_opinion) EditText tv_comentario;
    @BindView(R.id.rating_lugar)  RatingBar rtb_calificacion;
    @BindView(R.id.b_enviar)  Button b_enviar;
    @BindView(R.id.b_cancelar) Button b_cancelar;

    private ComentarioContract.Presenter presenter;
    private String comentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);

        ButterKnife.bind(this);

        presenter = new ComentarioPresenter(getContext(), this);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                comentId= null;
            } else {
                comentId = extras.getString("id");
            }
        } else {
            comentId = (String) savedInstanceState.getSerializable("id");
        }
    }

    @OnClick(R.id.b_cancelar)
    public void cancelar() {
        finish();
    }

    @OnClick(R.id.b_enviar)
    public void enviar() {
        if (isComentValido()) {
            Comentario comentario =
                    new Comentario(comentId, rtb_calificacion.getRating(),
                            tv_comentario.getText().toString());

            presenter.enviarComentario(comentario, comentId);
        } else {
            Util.showMessage(this, "Debe puntuar el lugar");
        }
    }

    @Override
    public Context getContext() {
        return getBaseContext();
    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        hideProgressDialog();
    }

    @Override
    public void response(String msj, int estado) {
        Util.showMessage(this, msj);
        hideProgressDialog();
        finish();
    }

    /**
     *  VALIDACIONES PARA EL COMENTARIO
     */

    private boolean isComentValido() {
        if (rtb_calificacion.getRating() > 0) {
            return true;
        }
        return false;
    }
}
