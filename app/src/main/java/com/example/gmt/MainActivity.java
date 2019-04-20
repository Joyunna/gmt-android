package com.example.gmt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   DrawerLayout drawer;
  // ActionBarDrawerToggle toggle;
   boolean isDrawerOpend;
   Toolbar toolbar;
   ImageView imageView;
   ImageView imageVIew2;
   ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<MovieVO> movies = new Http().getMovies();

        imageView = (ImageView)findViewById(R.id.my);
        imageView.setOnClickListener(this);

        imageVIew2 = (ImageView)findViewById(R.id.ham);
        imageVIew2.setOnClickListener(this);

        ViewPager pager = (ViewPager)findViewById(R.id.poster);
        PosterPagerAdapter pagerAdapter = new PosterPagerAdapter(getSupportFragmentManager(), movies);
        pager.setAdapter(pagerAdapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout)findViewById(R.id.main_drawer);
        //toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setContentInsetsAbsolute(0,0);
       // toggle.syncState();

        NavigationView naviView = (NavigationView)findViewById(R.id.main_drawer_view);
        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                if(id == R.id.menu_drawer_home){

                    showToast("home");
                }else if(id == R.id.menu_drawer_message){

                    showToast("message");
                }else if(id == R.id.menu_drawer_add){

                    showToast("add");
                }
                return false;
            }
        });

    }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.my:
                    drawer.openDrawer(GravityCompat.END);
                    break;
                case R.id.ham:
                    drawer.openDrawer(GravityCompat.START);
                    break;
            }
        }

        /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(toggle.onOptionsItemSelected(item)){

            return false;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    private void showToast(String message){

        Toast t = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }
}
