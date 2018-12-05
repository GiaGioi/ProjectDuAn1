package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.model.Health;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;
import com.developer.giagioi.projectduan1.sqlitedao.HealthDAO;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {

    private EditText edNamePet;
    private EditText edChungLoai;
    private EditText edSoLuong;
    private EditText edTinhTrang;
    private Button btnAdd;
    String idHealth = "";
    HealthDAO healthDAO;
    private ArrayList<Health> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        edNamePet = findViewById(R.id.edNamePet);
        edChungLoai = findViewById(R.id.edChungLoai);
        edSoLuong = findViewById(R.id.edSoLuong);
        edTinhTrang = findViewById(R.id.edTinhTrang);
        btnAdd = findViewById(R.id.btnAdd);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edNamePet.getText().length() == 0 ||
                        edChungLoai.getText().length() == 0 ||
                        edSoLuong.getText().length() == 0 ||
                        edTinhTrang.getText().length() == 0) {
                    Toast.makeText(HealthActivity.this, "Bạn phải nhập đủ thông tin ", Toast.LENGTH_SHORT).show();

                } else {
                    HealthDAO healthDAO = new HealthDAO(HealthActivity.this);
                    Health health = new Health(idHealth,edNamePet.getText().toString(),
                            edChungLoai.getText().toString(),
                            Integer.parseInt(edSoLuong.getText().toString()),
                            edTinhTrang.getText().toString());
                    try {
                        if (validateForm() > 0) {
                            if (healthDAO.insertHealth(health) > 0) {
                                arrayList.add(0, health);
                                Toast.makeText(getApplicationContext(), "Thêm thành công",
                                        Toast.LENGTH_SHORT).show();
                                getTypeBook();
                            } else {
                                Toast.makeText(getApplicationContext(), "Thêm thất bại",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (Exception ex) {
                        Log.e("Error", ex.toString());
                    }
                }
            }
        });
    }
    public void getTypeBook() {
        healthDAO = new HealthDAO(HealthActivity.this);
        arrayList = (ArrayList<Health>) healthDAO.getAllHealth();
        ArrayAdapter<Health> dataAdapter = new ArrayAdapter<Health>(this,
                android.R.layout.simple_spinner_item, arrayList);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
    public int validateForm() {
        int check = 1;
        if (edNamePet.getText().length() == 0 ||
                edChungLoai.getText().length() == 0 ||
                edSoLuong.getText().length() == 0 ||
                edTinhTrang.getText().length() == 0) {
            Toast.makeText(this, "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
    public int checkPositionTypeBook(String strTypeBook) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (strTypeBook.equals(arrayList.get(i).getIdPet())) {
                return i;
            }
        }
        return 0;
    }

}


