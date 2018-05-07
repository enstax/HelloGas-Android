package com.enstax.cesarcano.hellogas.domain.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Comentario {
    private String id;
    private String usuario;
    private float calificacion;
    private String comentario;
    private String fecha_creacion;
    private int likes;
    private int dislikes;
    private String item_id;
    private String user_id;

    public Comentario() {
    }

    // CONSTRUCTOR PARA CUANDO SE ENVÍA UN COMENTARIO
    public Comentario(String item_id, float calificacion, String comentario) {
        this.item_id = item_id;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}