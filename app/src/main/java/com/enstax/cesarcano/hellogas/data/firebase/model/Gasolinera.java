package com.enstax.cesarcano.hellogas.data.firebase.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Gasolinera {
    private String id;
    private String marca;
    private String direccion;
    private Double latitud;
    private Double longitud;

    public Gasolinera() {
    }

    public Gasolinera(String marca, String direccion, Double latitud, Double longitud) {
        this.marca = marca;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}