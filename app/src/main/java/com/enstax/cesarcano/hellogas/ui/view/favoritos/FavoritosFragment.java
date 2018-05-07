package com.enstax.cesarcano.hellogas.ui.view.favoritos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.favoritos.FavoritosPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseFragment;
import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.adapter.ListGasolineras;
import com.enstax.cesarcano.hellogas.ui.view.favoritos.adapter.ListFavoritos;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.GasolineraActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by cesarcanojmz@gmail.com
 */


public class FavoritosFragment extends BaseFragment implements FavoritosContract.View {

    @BindView(R.id.list_favoritos) ListView listView;
    private FavoritosContract.Presenter presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favoritos, container, false);

        ButterKnife.bind(this, view);

        presenter = new FavoritosPresenter(this);
        presenter.loadFavoritos();

        return view;
    }


    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        hideProgressDialog();
        Util.showMessage(getContext(), "Error");
    }

    @Override
    public void loadList(ArrayList<Gasolinera> gasolineras) {
        ArrayList<Gasolinera> gasList = new ArrayList<>();
        gasList = gasolineras;
        for (Gasolinera gasolinera: gasolineras) {
            Log.d("loadList: ", gasolinera.toString());
        }
        ListFavoritos adapter = new ListFavoritos(getContext(), gasList);
        listView.setAdapter(adapter);
        hideProgressDialog();
    }

    @OnItemClick(R.id.list_favoritos)
    public void onItemClick(int position) {
        Gasolinera gasolinera = (Gasolinera) listView.getItemAtPosition(position);
        Util.setIntentExtra(getActivity(), GasolineraActivity.class, gasolinera.getId());
    }
}