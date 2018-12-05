package com.developer.giagioi.projectduan1.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;

import java.util.ArrayList;

public class AddDogActivity extends AppCompatActivity {

    private EditText edtChungLoai;
    private EditText edtNamePet;
    private EditText edtSoluong;
    private EditText edtGioitinh;
    private EditText edtTinhtrang;
    private Button btnAdd;
    private ArrayList<AddDog> arrayList;
    private AddDogDAO addDogDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);
        init();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public void init(){
        edtNamePet = findViewById(R.id.edtNamePet);
        edtChungLoai = findViewById(R.id.edtChungLoai);
        edtSoluong = findViewById(R.id.edtSoluong);
        edtGioitinh = findViewById(R.id.edtGioitinh);
        edtTinhtrang = findViewById(R.id.edtTinhtrang);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNamePet.getText().length() == 0 ||
                        edtChungLoai.getText().length() == 0 ||
                        edtSoluong.getText().length() == 0 ||
                        edtGioitinh.getText().length() == 0 ||
                        edtTinhtrang.getText().length() == 0) {
                    Toast.makeText(AddDogActivity.this, "Bạn phải nhập đủ thông tin ", Toast.LENGTH_SHORT).show();

                } else {
                    addDogDAO = new AddDogDAO(AddDogActivity.this);
                    AddDog addDog = new AddDog(edtNamePet.getText().toString(),
                            edtChungLoai.getText().toString(),
                            Integer.parseInt(edtSoluong.getText().toString()),
                            edtGioitinh.getText().toString(),
                            edtTinhtrang.getText().toString());

                    try {
                        if (validateForm() > 0) {
                            if (addDogDAO.insertAddDog(addDog) > 0) {
                                arrayList.add(0, addDog);
                                Toast.makeText(getApplicationContext(), "Thêm thành công",
                                        Toast.LENGTH_SHORT).show();
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
    public int validateForm() {
        int check = 1;
        if (edtChungLoai.getText().length() == 0 ||
                edtNamePet.getText().length() == 0 ||
                edtSoluong.getText().length() == 0 ||
                edtGioitinh.getText().length() == 0 ||
                edtTinhtrang.getText().length() == 0) {
            Toast.makeText(this, "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }

}
