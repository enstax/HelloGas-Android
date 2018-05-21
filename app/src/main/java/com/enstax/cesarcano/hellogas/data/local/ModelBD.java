package com.enstax.cesarcano.hellogas.data.local;

/**
 * Created by cesarcanojmz@gmail.com
 */

public interface ModelBD {
    interface Gasolineras {
        String TABLE_NAME = "gasolineras";
        String ID = "id";
        String MARCA = "marca";
        String DIRECCION = "direccion";
        String VALORACION = "valoracion";
        String LATITUD = "latitud";
        String LONGITUD = "longitud";
        String HASPROMO = "promo";
        String LAST_PRICE = "ultimo_precio";
        String UPDATE = "fecha_act";
        String TIME = "hora_act";
        String REGULAR = "gas_regular";
        String PREMIUM = "gas_premium";
        String DIESEL = "gas_diesel";
    }
    interface Favoritos {
        String TABLE_NAME = "favoritos";
        String GASOLINERA_ID = "gasolinera_id";
        String USER_ID = "user_id";
    }
}