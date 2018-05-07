package com.enstax.cesarcano.hellogas.ui.view.configuracion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseFragment;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cesarcanojmz@gmail.com
 */
public class ConfiguracionesFragment extends BaseFragment {

    @BindView(R.id.b_miperfil)
    Button b_miPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_preferencias, container, false);

        ButterKnife.bind(this, view);

        getFragmentManager().beginTransaction().replace(R.id.f_preferences,
              new Preferences()).commit();

        return view;
    }
}