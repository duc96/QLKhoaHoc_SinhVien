package com.example.asm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.asm.fragment.DanhSachKhoaHocFragment;
import com.example.asm.fragment.KhoaHocCuaToiFragment;
import com.google.android.material.navigation.NavigationView;

public class KhoaHocActivity extends AppCompatActivity {

    public static Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoa_hoc);

        mapComponent();

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.khoaHocCuaToi:
                        toolbar.setTitle("Khóa Học Của Tôi");
                        KhoaHocCuaToiFragment f1 = new KhoaHocCuaToiFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayout,f1)
                                .commit();
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.danhSachKhoaHoc:
                        toolbar.setTitle("Danh Sách Khóa Học");
                        DanhSachKhoaHocFragment f2 = new DanhSachKhoaHocFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.framelayout,f2)
                                .commit();
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.thoat:
                        System.exit(0);
                        break;
                }
                return false;
            }
        });
    }

    protected void mapComponent(){
        toolbar =findViewById(R.id.toolbar);
        navigationView =findViewById(R.id.nvView);
        drawerLayout =findViewById(R.id.draw_layout);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSwipeRight(KhoaHocActivity.this);
    }
}
