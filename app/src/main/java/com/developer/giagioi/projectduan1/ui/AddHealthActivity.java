package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.adapter.HealthAdapter;
import com.developer.giagioi.projectduan1.model.Health;
import com.developer.giagioi.projectduan1.sqlitedao.HealthDAO;

import java.util.ArrayList;
import java.util.List;

public class AddHealthActivity extends AppCompatActivity {

    private ListView lvaddhealth;

    public static List<Health> arrayList = new ArrayList<>();
    HealthAdapter adapter = null;
    HealthDAO healthDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health);
        lvaddhealth = findViewById(R.id.lvaddhealth);
        healthDAO= new HealthDAO(AddHealthActivity.this);

        adapter = new HealthAdapter(this, arrayList);
        lvaddhealth.setAdapter(adapter);
        lvaddhealth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Health health = (Health) parent.getItemAtPosition(position);
                Intent intent = new Intent(AddHealthActivity.this, HealthActivity.class);
                Bundle b = new Bundle();
                b.putString("IDPet", health.getIdPet());
                b.putString("NAMEPET", health.getNamePet());
                b.putString("CHUNGLOAI", health.getChungLoai());
                b.putString("SOLUONG", String.valueOf(health.getSoLuong()));
                b.putString("TINHTRANG", health.getTinhTrang());
                intent.putExtras(b);
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.itemthem){
            startActivity(new Intent(AddHealthActivity.this,HealthActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
