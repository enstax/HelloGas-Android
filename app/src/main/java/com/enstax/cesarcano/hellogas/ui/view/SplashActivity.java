package com.enstax.cesarcano.hellogas.ui.view;

import android.content.Intent;
import android.os.SystemClock;
import android.os.Bundle;

import com.enstax.cesarcano.hellogas.ui.helper.base.BaseActivity;
import com.enstax.cesarcano.hellogas.ui.view.login.LoginActivity;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start home activity
        SystemClock.sleep(2000);
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

        // close splash activity
        finish();
    }
}
