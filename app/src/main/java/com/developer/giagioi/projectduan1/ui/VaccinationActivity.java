package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.AddDog;
import com.developer.giagioi.projectduan1.model.Vaccin;
import com.developer.giagioi.projectduan1.sqlitedao.AddDogDAO;
import com.developer.giagioi.projectduan1.sqlitedao.VaccinDAO;

import java.util.ArrayList;

public class VaccinationActivity extends AppCompatActivity {

    private Switch btnswitch;
    private ImageView linkanh;
    private Button btnchosepicture;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    private ImageView image;
    private EditText edNamePet;
    private EditText edLoaiThucAn;
    private EditText edSoLuong;
    private ArrayList<Vaccin> arrayList;
    private VaccinDAO vaccinDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);
        anhXa();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        btnchosepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });
        btnswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(VaccinationActivity.this, "Thú cưng đã được tiêm phòng", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VaccinationActivity.this, "Thú cưng chưa được tiêm phòng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhXa() {
        edNamePet = findViewById(R.id.edNamePet);
        edSoLuong = findViewById(R.id.edSoLuong);
        btnswitch = findViewById(R.id.btnswitch);
        linkanh = findViewById(R.id.linkanh);
        btnchosepicture = findViewById(R.id.btnchosepicture);
        image = findViewById(R.id.image);
    }

    private void OpenGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && resultCode == PICK_IMAGE) {
            imageUri = data.getData();
            image.setImageURI(imageUri);
        }
    }

    public void addVaccin(View view) {
        if (edNamePet.getText().length() == 0 ||
                edSoLuong.getText().length() == 0 ||
                edLoaiThucAn.getText().length() == 0){
            Toast.makeText(VaccinationActivity.this, "Bạn phải nhập đủ thông tin ", Toast.LENGTH_SHORT).show();

        } else {
            vaccinDAO = new VaccinDAO(VaccinationActivity.this);
            Vaccin vaccin = new Vaccin(edNamePet.getText().toString(),
                    edLoaiThucAn.getText().toString(),
                    Integer.parseInt(edSoLuong.getText().toString()));
            try {
                if (validateForm() > 0) {
                    if (vaccinDAO.insertVaccin(vaccin) > 0) {
                        arrayList.add(0, vaccin);
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

    public int validateForm() {
        int check = 1;
        if (edNamePet.getText().length() == 0 ||
                edLoaiThucAn.getText().length() == 0 ||
                edSoLuong.getText().length() == 0) {
            Toast.makeText(this, "Bạn phải nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
