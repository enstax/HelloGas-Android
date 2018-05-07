package com.enstax.cesarcano.hellogas.domain.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Servicio {
    private int id;
    private String id_gasolinera;
    private String nombre;
    private String usuario;
    private float calificacion;
    private String comentario;
    private int tipo;
    private int resource;
    private int isEnable;

    public Servicio() {
    }

    public Servicio(int id, String id_gasolinera, int tipo, int isEnable) {
        this.id = id;
        this.id_gasolinera = id_gasolinera;
        this.tipo = tipo;
        this.isEnable = isEnable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_gasolinera() {
        return id_gasolinera;
    }

    public void setId_gasolinera(String id_gasolinera) {
        this.id_gasolinera = id_gasolinera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }
}