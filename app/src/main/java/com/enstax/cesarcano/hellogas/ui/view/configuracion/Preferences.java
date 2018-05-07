package com.enstax.cesarcano.hellogas.ui.view.configuracion;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.enstax.cesarcano.hellogas.R;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class Preferences extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

}