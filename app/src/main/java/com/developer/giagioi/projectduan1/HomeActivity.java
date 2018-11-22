package com.developer.giagioi.projectduan1;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbarhome;
    private DrawerLayout drawerLayout;
    private LinearLayout layoutDog;
    private LinearLayout layoutCat;
    private LinearLayout layoutHeath;
    private LinearLayout layoutVaccin;
    private NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        khaibao();
        onclick();

    }
    public void khaibao(){
        toolbarhome = findViewById(R.id.toolbarhome);
        drawerLayout = findViewById(R.id.drawerLayout);
        layoutDog = findViewById(R.id.layout_Dog);
        layoutCat = findViewById(R.id.layout_Cat);
        layoutHeath = findViewById(R.id.layout_heath);
        layoutVaccin = findViewById(R.id.layout_vaccin);
        navigation = findViewById(R.id.navigation);
    }
    public void onclick(){
        layoutDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,DogActivity.class));
            }
        });
        layoutCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,CatActivity.class));
            }
        });
        layoutHeath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,HealthActivity.class));
            }

        });
        layoutVaccin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,VaccinationActivity.class));
            }
        });

    }
}
