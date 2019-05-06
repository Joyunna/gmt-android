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

import com.example.gmt.adapter.PosterPagerAdapter;
import com.example.gmt.service.PosterService;

import static com.example.gmt.utils.ToastUtil.showToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private ImageView profile;
    private ImageView btnHamburger;
    private ViewPager viewPager;
    private NavigationView leftNavigationView;
    private PosterService posterService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
        this.setEventListener();
    }

    private void init() {
        this.drawer = findViewById(R.id.main_drawer);
        this.profile = findViewById(R.id.main_btn_profile);
        this.btnHamburger = findViewById(R.id.main_btn_hamburger);
        this.viewPager = findViewById(R.id.main_poster_viewpager);
        this.leftNavigationView = findViewById(R.id.main_left_navigation);
        this.initToolbar();
        this.posterService = new PosterService();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setTitle("");
    }

    private void setEventListener() {
        drawer.setOnClickListener(this);
        this.profile.setOnClickListener(this);
        this.btnHamburger.setOnClickListener(this);
        this.leftNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        posterService.refreshMovies(this);
    }

    public void setPosterPagerAdapter(PosterPagerAdapter pagerPosterAdapter) {
        viewPager.setAdapter(pagerPosterAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_profile:
                drawer.openDrawer(GravityCompat.END);
                break;
            case R.id.main_btn_hamburger:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_drawer_home:
                showToast(this, "home");
            case R.id.menu_drawer_message:
                showToast(this, "message");
                return true;
            case R.id.menu_drawer_add:
                showToast(this, "add");
                return true;
            default:
                return false;
        }
    }
}