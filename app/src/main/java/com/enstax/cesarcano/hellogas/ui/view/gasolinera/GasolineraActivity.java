package com.enstax.cesarcano.hellogas.ui.view.gasolinera;

import android.content.Intent;
import android.os.Bundle;

import com.enstax.cesarcano.hellogas.R;
import com.enstax.cesarcano.hellogas.ui.helper.base.BaseActivity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

/**
 * Created by cesarcanojmz@gmail.com
 */

public class GasolineraActivity extends BaseActivity {

    String id_gas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasolinera);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Descripción "));
        tabLayout.addTab(tabLayout.newTab().setText("Opiniones"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        Intent intent = getIntent();
        id_gas = intent.getStringExtra("id");
        final ViewPager viewPager = findViewById(R.id.view_pager);
        final GasolineraPageAdapter pagerAdapter =
                new GasolineraPageAdapter(getSupportFragmentManager(),
                        tabLayout.getTabCount(), id_gas);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}
