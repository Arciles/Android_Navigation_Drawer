package com.arcileslab.arciles.drawerdeneme;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import navigationView.NavDrawerItem;
import navigationView.NavDrawerListAdapter;


public class MainActivity extends ActionBarActivity {

    private DrawerLayout navDrawerLayout;
    private ListView navDrawerListView;
    private ActionBarDrawerToggle navDrawerActionBarToggle;

    private CharSequence navDrawerTitle;
    private CharSequence appTitle;

    private String[] navDrawerItemTitles;
    private TypedArray navDrawerItemIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter navDrawerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appTitle = this.getTitle();
        this.navDrawerTitle = this.getTitle();
        navDrawerListView = (ListView) findViewById(R.id.drawerList);
        navDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navDrawerItems = new ArrayList<NavDrawerItem>();
        this.navDrawerItemTitles = this.getResources().getStringArray(R.array.nav_drawer_tab_names);
        this.navDrawerItemIcons = this.getResources().obtainTypedArray(R.array.nav_drawer_tab_icons);

        for (int i = 0 ; i < navDrawerItemIcons.length(); i++) {
            navDrawerItems.add(new NavDrawerItem(navDrawerItemTitles[i],navDrawerItemIcons.getResourceId(i,-1)));
        }
        navDrawerItemIcons.recycle();

        navDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DisplayFragment(position);
                setTitle(navDrawerItemTitles[position]);
                navDrawerListView.setItemChecked(position,true);
                navDrawerLayout.closeDrawer(navDrawerListView);
            }
        });

        navDrawerListAdapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
        navDrawerListView.setAdapter(navDrawerListAdapter);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        navDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        this.navDrawerActionBarToggle = new ActionBarDrawerToggle(this,navDrawerLayout,R.drawable.ic_drawer,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(navDrawerTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(appTitle);
                invalidateOptionsMenu();
            }
        };
        navDrawerLayout.setDrawerListener(navDrawerActionBarToggle);


        if (savedInstanceState == null)
            DisplayFragment(0);
    }

    private void DisplayFragment( int position) {

       Fragment fragment = null;

        switch (position)
        {
            case 0:
                fragment = new DogaFragment();
                break;
            case 1:
                fragment = new UzayFragment();
                break;
            case 2:
                fragment = new MacroFragment();
                break;
            case 3:
                fragment = new ArabalarFragment();
                break;
            case 4:
                fragment = new MuzikFragment();
                break;
            case 5:
                fragment = new FilmlerFragment();
                break;
            case 6:
                fragment = new DizilerFragment();
                break;
            case 7:
                fragment = new SehirlerFragment();
                break;
            case 8:
                fragment = new SoyutFragment();
                break;
            case 9:
                fragment = new FantaziFragment();
                break;
            case 10:
                fragment = new OyunlarFragment();
                break;
            case 11:
                fragment = new HayvanlarFragment();
                break;
            case 12:
                fragment = new KaplamaFragment();
            default:
                    break;

        }
        if (fragment != null)
            this.getFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
        else
            Log.e("Error","Gecis Icın Gerekli Fragment Yaratilamadi.");

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_clear_cache).setVisible(!this.navDrawerLayout.isDrawerOpen(R.id.drawerList));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.navDrawerActionBarToggle.syncState();
    }

    @Override
    public void setTitle(CharSequence title) {
        this.getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (this.navDrawerActionBarToggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()) {
            case R.id.action_clear_cache:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
    }
}
