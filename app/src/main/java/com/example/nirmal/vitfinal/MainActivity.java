package com.example.nirmal.vitfinal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm ;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        main_fragment myFragment = new main_fragment();
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.content_main,myFragment).commit();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft2 = fm.beginTransaction();
        switch (id){
            case R.id.nav_sen:
                formal_fragment myFrag = new formal_fragment();
                ft2.replace(R.id.content_main,myFrag).commit();
                break;
            case R.id.nav_send:
                culturals_fragment myFrag2 = new culturals_fragment();
                ft2.replace(R.id.content_main,myFrag2).commit();
                break;
            case R.id.nav_shar:
                sports_fragment myFrag4 = new sports_fragment();
                ft2.replace(R.id.content_main,myFrag4).commit();
                break;

            case R.id.nav_share:
                informal_fragment myFrag3 = new informal_fragment();
                ft2.replace(R.id.content_main,myFrag3).commit();
                break;
            case R.id.nav_map:
                mapp myFragg = new mapp();
                ft2.replace(R.id.content_main,myFragg).commit();
                break;

            case R.id.nav_proshow:
                proshow myFrag1 = new proshow();
                ft2.replace(R.id.content_main,myFrag1).commit();
                break;

            case R.id.nav_schedule:
                Schedule myFragg3 = new Schedule();
                ft2.replace(R.id.content_main,myFragg3).commit();
                break;
            case R.id.nav_about:
                Aboutus myFragg4 = new Aboutus();
                ft2.replace(R.id.content_main,myFragg4).commit();
                break;

            case R.id.nav_contact:
                Contact myFragg5 = new Contact();
                ft2.replace(R.id.content_main,myFragg5).commit();
                break;


        }
        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
