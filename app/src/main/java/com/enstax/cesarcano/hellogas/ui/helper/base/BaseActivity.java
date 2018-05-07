package com.enstax.cesarcano.hellogas.ui.helper.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.enstax.cesarcano.hellogas.R;


/**
 * Created by cesarcanojmz@gmail.com
 */

public class BaseActivity extends AppCompatActivity {
    public ProgressDialog mProgressDialog;
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}