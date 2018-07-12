package com.enstax.cesarcano.hellogas.data.firebase;

import com.enstax.cesarcano.hellogas.data.firebase.model.User;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class HgFirebaseDB {

    private DatabaseReference mDatabase;

    public HgFirebaseDB() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void createUser(String userId, String nombre, String email) {
        User user = new User(nombre, email);
        Map<String, Object> userValues = user.toMap();
        Map<String, Object> branch = new HashMap<>();
        branch.put("/users/" + userId, userValues);

        mDatabase.updateChildren(branch, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    // Enviar mensaje de error
                } else {
                    // Enviar mensaje de completado
                }
            }
        });
    }

    public void updateUser(String userId, String nombre, String email, String sexo, String edad) {
        User user = new User(nombre, email, edad, sexo);
        Map<String, Object> userValues = user.toMap();
        Map<String, Object> branch = new HashMap<>();
        branch.put("/users/" + userId, userValues);
        mDatabase.updateChildren(branch, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    // Enviar mensaje de error
                } else {
                    // Enviar mensaje de completado
                }
            }
        });
    }

    /*
        CRUD GASOLINERAS
     */
    public void updateCostos(String gasId, String regular, String premium, String diesel) {
        HashMap<String, Object> combustibles = new HashMap<>();
        Map<String, Object> branch = new HashMap<>();
        combustibles.put("regular", regular);
        combustibles.put("premium", premium);
        combustibles.put("diesel", diesel);

        branch.put("/combustibles/" + gasId, combustibles);

        mDatabase.updateChildren(branch, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    // Enviar mensaje de error
                } else {
                    // Enviar mensaje de completado
                }
            }
        });
    }


    public JSONArray getGasDetalle() {
        return null;
    }

    public void addfavorito(String idGasolinera, String idUser) {
        HashMap<String, Object> favorito = new HashMap<>();
        Map<String, Object> branch = new HashMap<>();
        favorito.put(idGasolinera, "true");
        branch.put("/favoritos/" + idUser, favorito);

        mDatabase.updateChildren(branch, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    // Enviar mensaje de error
                } else {
                    // Enviar mensaje de completado
                }
            }
        });
    }

    public void deleteFavorito(String idUser, String idGasolinera) {
        mDatabase.child("favoritos").child(idUser).child(idGasolinera).removeValue();
    }

    public void updateServicios(String gasId, int atm, int sanitarios, int shop) {
        HashMap<String, Object> servicios = new HashMap<>();
        Map<String, Object> branch = new HashMap<>();
        servicios.put("atm", atm);
        servicios.put("shop", shop);
        servicios.put("wc", sanitarios);

        branch.put("/servicios/" + gasId, servicios);

        mDatabase.updateChildren(branch, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    // Enviar mensaje de error
                } else {
                    // Enviar mensaje de completado
                }
            }
        });
    }

    // COMENTARIO
    public void agregarComentario(String idGas, String idUser, int calificacion,
                                  int texto, String fecha) {
        HashMap<String, Object> comentario = new HashMap<>();
        Map<String, Object> branch = new HashMap<>();
        String key = mDatabase.child("comentarios/" + idGas).push().getKey();
        comentario.put("gid", idGas);
        comentario.put("texto", texto);
        comentario.put("user", idUser);
        comentario.put("fecha", fecha);
        comentario.put("calificacion", calificacion);
        comentario.put("likes", 0);
        comentario.put("dislikes", 0);
        branch.put("/comentarios/" + idGas + "/" + key, comentario);

        mDatabase.updateChildren(branch, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    // Enviar mensaje de error
                } else {
                    // Enviar mensaje de completado
                }
            }
        });
    }
}