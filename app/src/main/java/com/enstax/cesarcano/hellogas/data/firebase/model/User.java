package com.enstax.cesarcano.hellogas.data.firebase.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class User {
    private String nombre;
    private String email;
    private String edad;
    private String sexo;

    public User() {
    }

    // Usado para registrar los datos del usuario
    public User(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.edad = null;
        this.sexo = null;
    }

    // PARA ACTUALIZACIÓN DE LOS DATOS DEL USUARIO EN SECCIÓN PERFIL
    public User(String nombre, String email, String edad, String sexo) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nombre", nombre);
        result.put("email", email);
        result.put("edad", edad);
        result.put("sexo", sexo);

        return result;
    }
}