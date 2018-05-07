package com.enstax.cesarcano.hellogas.domain.presenter.favoritos;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.favoritos.iterators.Favoritos;
import com.enstax.cesarcano.hellogas.domain.presenter.favoritos.iterators.GetFavoritos;
import com.enstax.cesarcano.hellogas.ui.view.favoritos.FavoritosContract;
import com.enstax.cesarcano.hellogas.ui.view.favoritos.FavoritosFragment;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */
public class FavoritosPresenter implements FavoritosContract.Presenter, Favoritos.Iterator {

    private FavoritosContract.View favoritosView;

    public FavoritosPresenter(FavoritosFragment favoritosFragment) {
        this.favoritosView = favoritosFragment;
    }

    @Override
    public void attachView(FavoritosContract.View view) {
        this.favoritosView = view;
    }

    @Override
    public void detachView() {
        this.favoritosView = null;
    }

    @Override
    public void loadFavoritos() {
        Favoritos.Get favoritos = new GetFavoritos(this, favoritosView.getContext());
        favoritos.getAll();
        favoritosView.loading();
    }

    @Override
    public void deleteFavorito() {

    }
    @Override
    public void load(ArrayList<Gasolinera> gasolineras) {
        favoritosView.loadList(gasolineras);
    }
}