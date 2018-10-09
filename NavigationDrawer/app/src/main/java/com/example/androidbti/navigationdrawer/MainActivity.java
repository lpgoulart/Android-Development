package com.example.androidbti.navigationdrawer;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SlidingDrawer;

public class MainActivity extends AppCompatActivity implements PlanetAdapter.OnItemClickListener{

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private Planet planetselecter;

    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerList.setAdapter(new PlanetAdapter(this, this));

        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                setTitle(R.string.title_choose);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if (planetselecter != null) {
                    setTitle(planetselecter.getName());
                } else {
                    setTitle(R.string.app_name);
                }
                invalidateOptionsMenu();
            }
        };

        if( savedInstanceState == null ) {
            selectItem(null);
        }else {
            planetselecter = (Planet) savedInstanceState.getSerializable("planet");
            selectItem(planetselecter);
        }

        drawerLayout.addDrawerListener(drawerToggle);

    }

    @Override
    public void onClick(Planet planet) {
        selectItem(planet);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        MenuItem searchMenu = menu.findItem(R.id.action_search);
        searchMenu.setVisible(!drawerOpen && planetselecter!=null);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if ( item.getItemId() == R.id.action_search ) {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,"Planet"+planetselecter.getName());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem (Planet planet) {
        if (planet != null) {
            this.planetselecter = planet;
            Fragment fragment = PlanetFragment.newInstance(planet);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();
            setTitle(planet.getName());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putSerializable("planet",planetselecter);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
