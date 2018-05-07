package com.enstax.cesarcano.hellogas.data.firebase.model;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class User {
    private String nombre;
    private String email;

    public User() {
    }

    public User(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}