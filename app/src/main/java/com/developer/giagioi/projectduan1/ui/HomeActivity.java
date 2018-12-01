package com.developer.giagioi.projectduan1.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbarhome;
    private DrawerLayout drawerLayout;
    private LinearLayout layoutDog;
    private LinearLayout layoutCat;
    private LinearLayout layoutHeath;
    private LinearLayout layoutVaccin;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        khaibao();
        onclick();

    }

    public void khaibao() {
        toolbarhome = findViewById(R.id.toolbarhome);
        toolbarhome.setTitle("Quản lí vật nuôi");
        setSupportActionBar(toolbarhome);
        drawerLayout = findViewById(R.id.drawerLayout);
        layoutDog = findViewById(R.id.layout_Dog);
        layoutCat = findViewById(R.id.layout_Cat);
        layoutHeath = findViewById(R.id.layout_heath);
        layoutVaccin = findViewById(R.id.layout_vaccin);
        navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onclick() {
        layoutDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DogActivity.class));
            }
        });
        layoutCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CatActivity.class));
            }
        });
        layoutHeath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddHealthActivity.class));
            }

        });
        layoutVaccin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AddVaccinActivity.class));
            }
        });
        toolbarhome.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ic_Dog:
                startActivity(new Intent(HomeActivity.this,AddDogActivity.class));
                break;

            case R.id.ic_Cat:
                startActivity(new Intent(HomeActivity.this,AddCatActivity.class));
                break;

            case R.id.ic_heath:
                startActivity(new Intent(HomeActivity.this,HealthActivity.class));
                break;

            case R.id.ic_gt:
                startActivity(new Intent(HomeActivity.this,InfoActivity.class));
                break;

            case R.id.ic_thoat:
                Exit();
                break;


        }
        drawerLayout.closeDrawer(Gravity.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itThemTK:
                startActivity(new Intent(HomeActivity.this,AddUserActivity.class));
                break;
            case R.id.itDMK:
                startActivity(new Intent(HomeActivity.this,ChangePasswordActivity.class));
                break;
            case R.id.itDX:
                startActivity(new Intent(HomeActivity.this,SignInActivity.class));
                break;
        }
        return true;
    }

    public void Exit() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thoát");
        builder.setMessage("Bạn có muốn thoát không?");
        builder.setIcon(R.drawable.ic_clear_back_24dp);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();



    }
}
