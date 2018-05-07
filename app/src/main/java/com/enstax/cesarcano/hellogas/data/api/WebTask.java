package com.enstax.cesarcano.hellogas.data.api;

import org.json.JSONObject;

/**
 * Created by cesarcanojms@gmail.com.
 */

public interface WebTask {
    interface Api {
        void request(String url);
    }
    interface Presenter {
        void response(JSONObject jsonObject);
    }
}
