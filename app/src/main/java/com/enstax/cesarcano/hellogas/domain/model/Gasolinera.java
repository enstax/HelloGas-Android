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
    private String hora_actualizacion;
    private Double gasRegular;
    private Double gasPremium;
    private Double gasDiesel;

    // CONSTRUCTOR PARA MARCADORES EN MAPA
    public Gasolinera(String id, String marca, String domicilio, Double latitud,
                      Double longitud, float valoracion, int promo, String fecha, String hora) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.posicion = new Geopunto(latitud, longitud);
        this.valoracion = valoracion;
        this.has_promo = promo;
        this.fecha_actualizacion = fecha;
        this.hora_actualizacion = hora;
    }

    // Constructor para lista de Gasolineras Cercanas
    public Gasolinera(String id, String marca, String domicilio, float valoracion,
                      Double lat, Double lng, int has_promo, String fecha, String hora) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.valoracion = valoracion;
        this.posicion = new Geopunto(lat, lng);
        this.has_promo = has_promo;
        this.fecha_actualizacion = fecha;
        this.hora_actualizacion = hora;
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
    public Gasolinera(String id, String marca, String domicilio, float valoracion,
                      Double latitud, Double longitud,Double gasRegular,
                      Double gasPremium, Double gasDiesel
                      ) {
        this.id = id;
        this.marca = marca;
        this.domicilio = domicilio;
        this.valoracion = valoracion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.gasDiesel = gasDiesel;
        this.gasPremium = gasPremium;
        this.gasRegular = gasRegular;
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

    public String getHora_actualizacion() {
        return hora_actualizacion;
    }

    public void setHora_actualizacion(String hora_actualizacion) {
        this.hora_actualizacion = hora_actualizacion;
    }

    public Double getGasRegular() {
        return gasRegular;
    }

    public void setGasRegular(Double gasRegular) {
        this.gasRegular = gasRegular;
    }

    public Double getGasPremium() {
        return gasPremium;
    }

    public void setGasPremium(Double gasPremium) {
        this.gasPremium = gasPremium;
    }

    public Double getGasDiesel() {
        return gasDiesel;
    }

    public void setGasDiesel(Double gasDiesel) {
        this.gasDiesel = gasDiesel;
    }

    @Override
    public String toString() {
        return "Gasolinera{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", valoracion=" + valoracion +
                ", posicion=" + posicion +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", has_promo=" + has_promo +
                ", fecha_actualizacion='" + fecha_actualizacion + '\'' +
                ", hora_actualizacion='" + hora_actualizacion + '\'' +
                '}';
    }
}
