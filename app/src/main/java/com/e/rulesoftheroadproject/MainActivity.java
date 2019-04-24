package com.e.rulesoftheroadproject;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment_quiz;
    Fragment fragment_practice;
    Fragment fragment_flash_cards;
    Fragment fragment_notes;
    Fragment fragment_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_quiz = new fragment_quiz();
        fragment_practice = new fragment_practice();
        fragment_flash_cards = new fragment_flash_cards();
        fragment_notes = new fragment_notes();
        fragment_main = new fragment_main();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment_main).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment selected = null;

        switch (id) {
            case R.id.nav_quiz:
                Toast.makeText(this, "Quiz", Toast.LENGTH_SHORT).show();
                selected = fragment_quiz;
                break;

            case R.id.nav_practice:
                Toast.makeText(this, "Practice", Toast.LENGTH_SHORT).show();
                selected = fragment_practice;
                break;

            case R.id.nav_flash_cards:
                Toast.makeText(this, "Flash Cards", Toast.LENGTH_SHORT).show();
                selected = fragment_flash_cards;
                break;

            case R.id.nav_notes:
                Toast.makeText(this, "Notes", Toast.LENGTH_SHORT).show();
                selected = fragment_notes;
                break;

            default:
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
