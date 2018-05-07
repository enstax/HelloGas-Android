package com.enstax.cesarcano.hellogas.data.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by cesarcanojms@gmail.com
 */

public class GApiTask implements WebTask.Api {

    private String api_url;
    private Context context;

    private WebTask.Presenter presenter;

    public GApiTask(WebTask.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void request(String url) {
        api_url = url;
        new ApiTask().execute();
    }

    class ApiTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            RequestQueue requestQueue = Volley.newRequestQueue(context);

            JsonObjectRequest jsonObjectRequest =
                    new JsonObjectRequest(Request.Method.GET, api_url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            presenter.response(response);

                        }

                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            });
            requestQueue.add(jsonObjectRequest);
            return null;
        }
    }
}