package com.enstax.cesarcano.hellogas.domain.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Gasolinera {
    private String id;
    private String marca;
    private String domicilio;
    private float valoracion;
    private Geopunto posicion;
    private Double latitud;
    private Double longitud;
    private int has_promo;
    private String fecha_actualizacion;
    private String nombre;

    // CONSTRUCTOR PARA MARCADORES EN MAPA
    public Gasolinera(String id, String marca, String domicilio, Double latitud, Double longitud, String nombre, float valoracion, int promo) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.posicion = new Geopunto(latitud, longitud);
        this.nombre = nombre;
        this.valoracion = valoracion;
        this.has_promo = promo;
    }

    // Constructor para lista de Gasolineras Cercanas
    public Gasolinera(String id, String marca, String domicilio, float valoracion, Geopunto posicion, int has_promo) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.valoracion = valoracion;
        this.posicion = posicion;
        this.has_promo = has_promo;
    }

    // Constructor para favoritos
    public Gasolinera(String id, String marca, String domicilio, Double latitud, Double longitud) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.posicion = new Geopunto(latitud, longitud);
    }

    // COSTRUCTOR DE DETALLE
    public Gasolinera(String id, String marca, String domicilio, float valoracion, Double latitud, Double longitud, String nombre) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.valoracion = valoracion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public Geopunto getPosicion() {
        return posicion;
    }

    public void setPosicion(Geopunto posicion) {
        this.posicion = posicion;
    }

    public int getHas_promo() {
        return has_promo;
    }

    public void setHas_promo(int has_promo) {
        this.has_promo = has_promo;
    }

    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Gasolinera{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", valoracion=" + valoracion +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", has_promo=" + has_promo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
