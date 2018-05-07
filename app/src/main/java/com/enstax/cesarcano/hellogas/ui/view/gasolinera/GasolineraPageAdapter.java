package com.enstax.cesarcano.hellogas.ui.view.gasolinera;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.enstax.cesarcano.hellogas.ui.view.gasolinera.comentarios.ComentariosGasolinera;
import com.enstax.cesarcano.hellogas.ui.view.gasolinera.detalle.DetalleGasolinera;


/**
 * Created by cesarcanojmz@gmail.com
 */

public class GasolineraPageAdapter extends FragmentPagerAdapter {

    private int numbOfTabs;
    private String idgasolinera;

    public GasolineraPageAdapter(FragmentManager fm, int numbOfTabs, String idGasolinera) {
        super(fm);
        this.numbOfTabs = numbOfTabs;
        this.idgasolinera = idGasolinera;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DetalleGasolinera gasolinera = new DetalleGasolinera();
                gasolinera.setIdgasolinera(idgasolinera);
                return gasolinera;
            case 1:
                ComentariosGasolinera comentariosGasolinera= new ComentariosGasolinera();
                comentariosGasolinera.setIdgasolinera(idgasolinera);
                return  comentariosGasolinera;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}