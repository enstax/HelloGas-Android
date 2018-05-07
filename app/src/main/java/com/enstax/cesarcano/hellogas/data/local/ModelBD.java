package com.enstax.cesarcano.hellogas.data.local;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface ModelBD {
    interface Gasolineras {
        String TABLE_NAME = "gasolineras";
        String ID = "id";
        String NOMBRE = "nombre";
        String MARCA = "marca";
        String DIRECCION = "direccion";
        String VALORACION = "valoracion";
        String LATITUD = "latitud";
        String LONGITUD = "longitud";
        String HASPROMO = "promo";
        String LAST_PRICE = "ultimo_precio";
        String UPDATE = "fecha_act";
    }
    interface Favoritos {
        String TABLE_NAME = "favoritos";
        String GASOLINERA_ID = "gasolinera_id";
        String USER_ID = "user_id";
    }
}