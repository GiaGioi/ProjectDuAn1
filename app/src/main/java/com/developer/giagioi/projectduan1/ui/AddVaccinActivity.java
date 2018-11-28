package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.adapter.AddDogAdapter;
import com.developer.giagioi.projectduan1.adapter.VaccinAdapter;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.model.Vaccin;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;
import com.developer.giagioi.projectduan1.sqlitedao.VaccinDAO;

import java.util.ArrayList;
import java.util.List;

public class AddVaccinActivity extends AppCompatActivity {

    ListView lvDog;
    public static List<Vaccin> vaccins = new ArrayList<>();
    private VaccinAdapter vaccinAdapter = null;
    VaccinDAO vaccinDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccin);
        lvDog = findViewById(R.id.lvaddvaccin);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        vaccinDAO = new VaccinDAO(this);
        vaccinAdapter = new VaccinAdapter(this,vaccins);
        lvDog.setAdapter(vaccinAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.itemthem){
            startActivity(new Intent(AddVaccinActivity.this,VaccinationActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        vaccins.clear();
        vaccinAdapter.changeDataset(vaccins);
        super.onResume();
    }
}
