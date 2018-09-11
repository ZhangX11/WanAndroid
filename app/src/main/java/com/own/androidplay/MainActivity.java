package com.own.androidplay;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.own.androidplay.base.BaseActivity;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        drawerLayout = findViewById(R.id.drawerLayout);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //创建抽屉的开关，将toolbar和DrawerLayout作为参数传递给它
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar
                , R.string.drawer_open, R.string.drawer_close);
        //实现toolbar和Drawer的联动
        toggle.syncState();
        //给DrawerLayout设置开关的监听
        drawerLayout.addDrawerListener(toggle);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"onSaveInstanceState 执行");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setCheckable(true);
        switch (item.getItemId()){
            case R.id.nightMode:
                Toast.makeText(this, "夜间模式", Toast.LENGTH_SHORT).show();
                break;
            case R.id.myBookMark:
                break;
            case R.id.myFavorite:
                break;
            case R.id.setting:
                break;
            case R.id.logout:
                Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }
}
