package com.enstax.cesarcano.hellogas.ui.view.search;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.domain.model.Gasolinera;
import com.enstax.cesarcano.hellogas.domain.presenter.SearchPresenter;
import com.enstax.cesarcano.hellogas.ui.helper.base.MyMapFragment;
import com.enstax.cesarcano.hellogas.ui.helper.utils.Util;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class SearchFragment extends MyMapFragment implements
        OnMapReadyCallback, LocationListener, SearchContract.View, GoogleMap.OnMarkerClickListener{
    private GoogleMap map;
    private Location myLocation;
    private LocationManager locationManager;
    // LOCACION NORMAL (Si no se carga la ubicacion)
    private final double DEFAULT_LAT = 19.4326077;
    private final double DEFAULT_LON = -99.13320799999997;
    private final int DEFAULT_LOCATION_ZOOM = 5;
    MapFragment mapFragment;
    // PARÁMETROS DE MAPA DEFAULT (Se carga la locacion)
    private final int MAX_ZOOM = 15;
    private final int MIN_ZOOM = 12;
    private final int DEFAULT_ZOOM = 13;

    private Marker mMarker;

    private SearchContract.Presenter searchPresenter;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
            updateMyLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
        }
        mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        searchPresenter = new SearchPresenter(this);
        searchPresenter.getPlacesInThisArea(19.4582572274277, -99.1273592784811);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(19.4582572274277, -99.1273592784811);
        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setCompassEnabled(true);
        map.setMaxZoomPreference(MAX_ZOOM);
        map.setMinZoomPreference(MIN_ZOOM);
        if (ContextCompat.checkSelfPermission(getActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            updateMyLocation(locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER));
            //location = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, DEFAULT_ZOOM));
            map.addMarker(new MarkerOptions().position(location).title("Estás aquí"));

        }

        map.setOnMarkerClickListener(this);
    }

    private void updateMyLocation(Location location) {
        if (location != null) {
            myLocation = location;
            showProgressDialog();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        updateMyLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void loadPlaces(ArrayList<Gasolinera> gasolineras) {
        for (int i = 0; i < gasolineras.size(); i++) {
            Gasolinera gasolinera = gasolineras.get(i);
            mMarker = map.addMarker(
                    new MarkerOptions().
                            position(new LatLng(gasolinera.getLatitud(), gasolinera.getLongitud()))
                            .title(gasolinera.getMarca())
            .snippet("Prueba"));
            Log.i("GASOLINERA " + i + " :", gasolinera.toString());
        }

        hideProgressDialog();
    }

    @Override
    public void loadPlaceInfo(Gasolinera gasolinera) {

    }

    @Override
    public void loading() {
        showProgressDialog();
    }

    @Override
    public void error() {
        Util.showMessage(getContext(), getString(R.string.search_error));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}