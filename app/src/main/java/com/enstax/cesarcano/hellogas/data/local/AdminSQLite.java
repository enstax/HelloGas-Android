package com.enstax.cesarcano.hellogas.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class AdminSQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hellogas";
    private static final int DATABASE_VERSION = 4;

    public AdminSQLite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %S (" +
                        "%S TEXT NULL, " +
                        "%S TEXT NULL, " +
                        "%S TEXT NULL, " +
                        "%S TEXT NULL, " +
                        "%S REAL NULL, " +
                        "%S REAL NULL, " +
                        "%S REAL NULL, " +
                        "%S INT NULL, " +
                        "%S REAL NULL, " +
                        "%S NUMERIC NULL );",
                ModelBD.Gasolineras.TABLE_NAME, ModelBD.Gasolineras.ID,  ModelBD.Gasolineras.NOMBRE,
                ModelBD.Gasolineras.MARCA, ModelBD.Gasolineras.DIRECCION, ModelBD.Gasolineras.VALORACION,
                ModelBD.Gasolineras.LATITUD, ModelBD.Gasolineras.LONGITUD, ModelBD.Gasolineras.HASPROMO,
                ModelBD.Gasolineras.LAST_PRICE, ModelBD.Gasolineras.UPDATE)
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ModelBD.Gasolineras.TABLE_NAME);
        onCreate(db);
    }
}