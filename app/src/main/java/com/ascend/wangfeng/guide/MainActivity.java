package com.ascend.wangfeng.guide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<Scenery> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initData();
        updateView(0);
    }

    private void initData() {
        mData =new ArrayList<Scenery>();
        mData.add(new Scenery(R.drawable.xh_lft,getString(R.string.xh_lft),getString(R.string.event_lft),getString(R.string.re_lft)));
        mData.add(new Scenery(R.drawable.xh_sdcx,getString(R.string.xh_sdcx),getString(R.string.event_sdcx),getString(R.string.re_sdcx)));
        mData.add(new Scenery(R.drawable.xh_dq,getString(R.string.xh_dqcx),getString(R.string.event_dq),getString(R.string.re_dq)));
        mData.add(new Scenery(R.drawable.xh_qufh,getString(R.string.xh_qyfh),getString(R.string.event_qufh),getString(R.string.re_qufh)));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_lft:
                updateView(0);
                break;
            case R.id.nav_sdcx:
                updateView(1);
                break;
            case R.id.nav_dq:
                updateView(2);
                break;
            case R.id.nav_qyfh:
                updateView(3);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateView(int i) {
        Scenery scenery =mData.get(i);
        ImageView imageView = (ImageView) findViewById(R.id.img);
        TextView sceneryView = (TextView) findViewById(R.id.scenery);
        TextView restaurant = (TextView) findViewById(R.id.restaurant);
        TextView event = (TextView) findViewById(R.id.event);
        imageView.setImageResource(scenery.getImg());
        sceneryView.setText(scenery.getTitle());
        restaurant.setText(scenery.getRestaurant());
        event.setText(scenery.getEvent());
    }
}
