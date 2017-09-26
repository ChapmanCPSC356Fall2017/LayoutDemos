package edu.chapman.cpsc356.layouts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

        getSupportFragmentManager().beginTransaction().replace(R.id.ll_content, new IntroFragment()).commit();
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_linearlayout)
        {
            ft.replace(R.id.ll_content, new LinearLayoutFragment());
        }
        else if (id == R.id.nav_relativelayout)
        {
            ft.replace(R.id.ll_content, new RelativeLayoutFragment());
        }
        else if (id == R.id.nav_framelayout)
        {
            ft.replace(R.id.ll_content, new FrameLayoutFragment());
        }
        else if (id == R.id.nav_absolutelayout)
        {
            ft.replace(R.id.ll_content, new AbsoluteLayoutFragment());
        }
        else if (id == R.id.nav_gridlayout)
        {
            ft.replace(R.id.ll_content, new GridLayoutFragment());
        }
        else if (id == R.id.nav_tablelayout)
        {
            ft.replace(R.id.ll_content, new TableLayoutFragment());
        }
        else if (id == R.id.nav_scrollview)
        {
            ft.replace(R.id.ll_content, new ScrollViewFragment());
        }

        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClickCell(View view)
    {
        Button theButton = (Button) view;
        theButton.setText("X");
    }

    public void onClickCard(View view)
    {
        // Animation
        view.animate().yBy(1000).setDuration(1000).start();
        view.animate().alpha(0).setDuration(1000).start();
        view.animate().rotation(180).setDuration(1000).start();
    }
}
