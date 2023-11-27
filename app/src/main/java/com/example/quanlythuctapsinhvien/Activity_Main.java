package com.example.quanlythuctapsinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//import com.example.managerstudent.Linh.L_BUS_Diem;
//import com.example.managerstudent.Linh.L_BUS_ThongTin;
//import com.example.managerstudent.Minh.KhoaActivity;
import com.example.quanlythuctapsinhvien.fragment.Fragment_BaoCaoTuan;
import com.example.quanlythuctapsinhvien.fragment.Fragment_BieuDo;
import com.example.quanlythuctapsinhvien.fragment.Fragment_Home;
import com.example.quanlythuctapsinhvien.fragment.Fragment_ThongBao;
import com.example.quanlythuctapsinhvien.fragment.Fragment_ThongKe;
import com.google.android.material.navigation.NavigationView;

public class Activity_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    //giup phat hien fragment nao dang mo
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_BAOCAOTUAN = 1;
    private static final int FRAGMENT_THONGBAO = 2;
    private static final int FRAGMENT_THONGKE = 3;
    private static final int FRAGMENT_BIEUDO = 4;

    //FRAGMENT DANG CHAY
    //gán nó mặc định là Fragment Home
    private int nowFragment = FRAGMENT_HOME;

    //---------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_action_bar);

        setControls();
        setEvents();
    }

    private void setControls() {
        drawerLayout = findViewById(R.id.drawer_Layout);
        toolbar = findViewById(R.id.nav_top_toobar);
        navigationView = findViewById(R.id.nav_view);
    }

    private void setEvents() {
        //dua toolbar vao
        setSupportActionBar(toolbar);

        //click open/close nav
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Log In APP mặc định vào Home Fragment
        replaceFragment(new Fragment_Home());
        navigationView.getMenu().findItem(R.id.menu_nav_Home).setChecked(true);

        //tao su kien khi nhan menu item.
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_nav_Home) {
            if (nowFragment != FRAGMENT_HOME) {
                replaceFragment(new Fragment_Home());
                nowFragment = FRAGMENT_HOME;
                defaultMenuSelect();
                navigationView.getMenu().findItem(R.id.menu_nav_Home).setChecked(true);
            }
        }
        if (id == R.id.menu_nav_BaoCaoTuan) {
            if (nowFragment != FRAGMENT_BAOCAOTUAN) {
                replaceFragment(new Fragment_BaoCaoTuan());
                nowFragment = FRAGMENT_BAOCAOTUAN;
                defaultMenuSelect();
                navigationView.getMenu().findItem(R.id.menu_nav_BaoCaoTuan).setChecked(true);
            }
        }
        if (id == R.id.menu_nav_ThongBao) {
            if (nowFragment != FRAGMENT_THONGBAO) {
                replaceFragment(new Fragment_ThongBao());
                nowFragment = FRAGMENT_THONGBAO;
                defaultMenuSelect();
                navigationView.getMenu().findItem(R.id.menu_nav_ThongBao).setChecked(true);
            }
        }
        if (id == R.id.menu_nav_ThongKe) {
            if (nowFragment != FRAGMENT_THONGKE) {
                replaceFragment(new Fragment_ThongKe());
                nowFragment = FRAGMENT_THONGKE;
                defaultMenuSelect();
                navigationView.getMenu().findItem(R.id.menu_nav_ThongKe).setChecked(true);
            }
        }
        if (id == R.id.menu_nav_BieuDo) {
            if (nowFragment != FRAGMENT_BIEUDO) {
                replaceFragment(new Fragment_BieuDo());
                nowFragment = FRAGMENT_BIEUDO;
                defaultMenuSelect();
                navigationView.getMenu().findItem(R.id.menu_nav_BieuDo).setChecked(true);
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout_replace, fragment);
        fragmentTransaction.commit();
    }

    private void defaultMenuSelect() {
        navigationView.getMenu().findItem(R.id.menu_nav_Home).setChecked(false);
        navigationView.getMenu().findItem(R.id.menu_nav_ThongBao).setChecked(false);
        navigationView.getMenu().findItem(R.id.menu_nav_ThongKe).setChecked(false);
        navigationView.getMenu().findItem(R.id.menu_nav_BieuDo).setChecked(false);
        navigationView.getMenu().findItem(R.id.menu_nav_BaoCaoTuan).setChecked(false);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            //neu nav dang mo, nhan nut 'back' se dong no lai, roi thoat app
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (toggle.onOptionsItemSelected(item))
//            return true;
//        return super.onOptionsItemSelected(item);
//    }
}