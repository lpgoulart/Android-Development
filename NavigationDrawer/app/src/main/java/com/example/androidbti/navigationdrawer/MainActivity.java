package com.example.androidbti.navigationdrawer;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements PlanetAdapter.OnItemClickListener{

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private Planet planetselecter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerList.setAdapter(new PlanetAdapter(this, this));

        selectItem(null);

    }

    @Override
    public void onClick(Planet planet) {
        selectItem(planet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
}
