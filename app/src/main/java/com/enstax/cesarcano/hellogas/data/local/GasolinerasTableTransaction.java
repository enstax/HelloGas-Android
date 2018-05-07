package com.enstax.cesarcano.hellogas.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class GasolinerasTableTransaction {

    private AdminSQLite adminSQLite;

    private final String TAG = "--> SQLITE TRANSACTION";

    public GasolinerasTableTransaction(Context context) {
        this.adminSQLite = new AdminSQLite(context);
    }

    public Cursor getGasolineraInfo(String id) {
        SQLiteDatabase db = adminSQLite.getReadableDatabase();
        String query = String.format("SELECT * FROM %S WHERE %S = %S;",
                ModelBD.Gasolineras.TABLE_NAME, ModelBD.Gasolineras.ID, id);
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        DatabaseUtils.dumpCursor(c);
        return c;
    }

    public Cursor getGasolinerasByCalificacion() {
        SQLiteDatabase db = adminSQLite.getReadableDatabase();
        String query = String.format("SELECT * FROM %S ORDER BY %S DESC;",
                ModelBD.Gasolineras.TABLE_NAME, ModelBD.Gasolineras.VALORACION );
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        DatabaseUtils.dumpCursor(c);
        return c;
    }

    public Cursor getGasolinerasByFecha() {
        SQLiteDatabase db = adminSQLite.getReadableDatabase();
        String query = String.format("SELECT * FROM %S ORDER BY %S;",
                ModelBD.Gasolineras.TABLE_NAME, ModelBD.Gasolineras.VALORACION );
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        DatabaseUtils.dumpCursor(c);
        return c;
    }

    public Cursor getGasolinerasByPrecio() {
        SQLiteDatabase db = adminSQLite.getReadableDatabase();
        // TODO Por ultimo precio actualizado
        String query = String.format("SELECT %S, %S, %S, %S, %S, %S, %S, %S  FROM %S;",
                ModelBD.Gasolineras.ID,
                ModelBD.Gasolineras.MARCA,
                ModelBD.Gasolineras.DIRECCION,
                ModelBD.Gasolineras.VALORACION,
                ModelBD.Gasolineras.LATITUD,
                ModelBD.Gasolineras.LONGITUD,
                ModelBD.Gasolineras.NOMBRE,
                ModelBD.Gasolineras.HASPROMO,
                ModelBD.Gasolineras.TABLE_NAME);
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
        }
        DatabaseUtils.dumpCursor(c);
        return c;
    }

    public void createGasolinera(ArrayList<Gasolinera> gasolineras){
        SQLiteDatabase db = adminSQLite.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (Gasolinera gasolinera: gasolineras) {
            values.put(ModelBD.Gasolineras.ID, gasolinera.getId());
            values.put(ModelBD.Gasolineras.DIRECCION, gasolinera.getDomicilio());
            values.put(ModelBD.Gasolineras.LATITUD, gasolinera.getLatitud());
            values.put(ModelBD.Gasolineras.LONGITUD, gasolinera.getLongitud());
            values.put(ModelBD.Gasolineras.MARCA, gasolinera.getMarca());
            values.put(ModelBD.Gasolineras.NOMBRE, gasolinera.getNombre());
            values.put(ModelBD.Gasolineras.VALORACION, gasolinera.getValoracion());
            values.put(ModelBD.Gasolineras.HASPROMO, gasolinera.getHas_promo());

            db.insert(ModelBD.Gasolineras.TABLE_NAME, null, values);
            Log.d(TAG, "createGasolinera: succesful");
        }
        db.close();
    }

    public void vaciarGasolineras() {
        try {
            SQLiteDatabase db = adminSQLite.getWritableDatabase();
            db.execSQL(String.format("DELETE FROM %S;",
                    ModelBD.Gasolineras.TABLE_NAME)
            );
            db.close();

            Log.d(TAG, "vaciarGasolineras: succesful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}