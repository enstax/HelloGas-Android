package com.enstax.cesarcano.hellogas.ui.view.home;

import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.presenter.HomePresenter;
import com.enstax.cesarcano.hellogas.ui.view.cercanas.CercanasFragment;
import com.enstax.cesarcano.hellogas.ui.view.configuracion.ConfiguracionesFragment;
import com.enstax.cesarcano.hellogas.ui.view.favoritos.FavoritosFragment;
import com.enstax.cesarcano.hellogas.ui.helper.BottomNavigationViewHelper;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseActivity;
import com.enstax.cesarcano.hellogas.ui.view.search.SearchFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class HomeActivity extends BaseActivity implements HomeContract.View{

    private HomeContract.Presenter presenter;
    private FirebaseAuth auth ;

    private final int PERMISO_UBICACION = 0;
    private final int VERIFICAR_GPS = 1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    Fragment search = new SearchFragment();
                    transaction.replace(R.id.fragment_container, search, "tag");
                    transaction.addToBackStack("tag");
                    transaction.commit();
                    return true;
                case R.id.navigation_cercanos:
                    Fragment cercanos = new CercanasFragment();
                    transaction.replace(R.id.fragment_container, cercanos, "tag");
                    transaction.addToBackStack("tag");
                    transaction.commit();
                    return true;
                case R.id.navigation_favoritos:
                    Fragment favoritos = new FavoritosFragment();
                    transaction.replace(R.id.fragment_container, favoritos, "tag");
                    transaction.addToBackStack("tag");
                    transaction.commit();
                    return true;
                case R.id.navigation_hellopoints:
                    return true;
                case R.id.navigation_preferencias:
                    Fragment preferencias = new ConfiguracionesFragment();
                    transaction.replace(R.id.fragment_container, preferencias, "tag");
                    transaction.addToBackStack("tag");
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setSelectedItemId(R.id.navigation_search);

        auth = FirebaseAuth.getInstance() ;

        presenter = new HomePresenter(auth, this);
        presenter.attachView(this);
        presenter.getCurrentUser();
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public void init() {
        /**
         *  SE REVISA EL GPS, SI NO ESTA ACTIVADO ABRE MENU CONFGS.
         *  DESPUES PIDE PERMISOS DE UBICACION
         */

        final LocationManager locationManager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            // Se verifican los permisos
            checkLocationPermission();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Activar GPS")
                    .setMessage("Debe activar su gps para una mejor experiencia de usuario")
                    .setPositiveButton("ACTIVAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivityForResult(
                                    new Intent(android.provider.Settings
                                            .ACTION_LOCATION_SOURCE_SETTINGS),
                                    VERIFICAR_GPS);
                        }
                    })
                    .create()
                    .show();
            checkLocationPermission();
        }
    }

    /*  < PEMISOS >*/
    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("Activar permiso de ubicación")
                        .setMessage("Debe activar el servicio de ubicacion")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(HomeActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        PERMISO_UBICACION);
                            }
                        })
                        .create()
                        .show();

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISO_UBICACION);
            }
        }
    }
    /*  < PEMISOS >*/

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISO_UBICACION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                    }
                    Toast.makeText(this, "Permiso activado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Necesita activar el permiso de ubicación", Toast.LENGTH_SHORT).show();
                    checkLocationPermission();
                }
                return;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == VERIFICAR_GPS) {
            if (resultCode == RESULT_OK) {
                checkLocationPermission();
            } else {
                init();
            }
            checkLocationPermission();
        }
    }
    /*  < PEMISOS /> */

    /* <!-- MENU --> */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.exit: // Termina la app
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /* <--- MENU --->*/

    @Override
    protected void onRestart() {
        super.onRestart();
        init();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loading() {

    }

    @Override
    public void error() {

    }

    @Override
    public void setEnabled(boolean isEnabled) {

    }

    @Override
    public void setUser(FirebaseUser user) {

    }
}
