package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.adapter.AddDogAdapter;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;

import java.util.ArrayList;
import java.util.List;

public class CatActivity extends AppCompatActivity {

    ListView lvDog;
    public static List<AddDog> addDogs = new ArrayList<>();
    AddDogAdapter addDogAdapter = null;
    AddDogDAO addDogDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        lvDog = findViewById(R.id.lvdog);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        addDogDAO = new AddDogDAO(this);
        addDogAdapter = new AddDogAdapter(this,addDogs);
        lvDog.setAdapter(addDogAdapter);
        lvDog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CatActivity.this, EditDogActivity.class);
                Bundle b = new Bundle();
                b.putString("ID", addDogs.get(position).getIDPet());
                b.putString("NAME", addDogs.get(position).getNamePet());
                b.putString("SOLUONG", String.valueOf(addDogs.get(position).getSoLuong()));
                b.putString("GIOITINH", addDogs.get(position).getGioiTinh());
                b.putString("TINHTRANG", addDogs.get(position).getTinhTrang());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
    public void init(){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.itemthem){
            startActivity(new Intent(CatActivity.this,AddCatActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        addDogs.clear();
        addDogAdapter.changeDataset(addDogs);
        super.onResume();
    }
}
