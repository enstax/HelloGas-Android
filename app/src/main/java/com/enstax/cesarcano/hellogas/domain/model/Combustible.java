package com.enstax.cesarcano.hellogas.domain.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Combustible {
    private int id;
    private String nombre;
    private String precio;
    private long update;
    private String gasolinera_id;
    private int user_id;

    // ESTADO
    private int estado;

    // DEFAULT VALUES
    private String PRECIO_DEFAULT = "MXN 0.00";
    private String PREFIJO_PRECIO = "MXN ";

    public Combustible() {}

    public Combustible(String nombre, Double precio) {
        this.nombre = nombre;
        if(precio <= 0) {
            this.precio = PRECIO_DEFAULT;
        } else {
            this.precio = PREFIJO_PRECIO + precio.toString();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public long getUpdate() {
        return update;
    }

    public void setUpdate(long update) {
        this.update = update;
    }

    public String getGasolinera_id() {
        return gasolinera_id;
    }

    public void setGasolinera_id(String gasolinera_id) {
        this.gasolinera_id = gasolinera_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPRECIO_DEFAULT() {
        return PRECIO_DEFAULT;
    }

    public void setPRECIO_DEFAULT(String PRECIO_DEFAULT) {
        this.PRECIO_DEFAULT = PRECIO_DEFAULT;
    }

    public String getPREFIJO_PRECIO() {
        return PREFIJO_PRECIO;
    }

    public void setPREFIJO_PRECIO(String PREFIJO_PRECIO) {
        this.PREFIJO_PRECIO = PREFIJO_PRECIO;
    }
}
