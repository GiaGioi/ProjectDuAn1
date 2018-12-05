package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.User;
import com.developer.giagioi.projectduan1.sqlitedao.UserDAO;

public class AddUserActivity extends AppCompatActivity {

    private Button btnsignin;
    private Button btnsignup;
    private EditText edUserName;
    private EditText edPassWord;
    private CheckBox chkRememberPass;
    private Button loginDangnhap;
    public String strUser, strPass;
    UserDAO userDAO;
    private EditText edRePassword;
    private EditText edName;
    private EditText edGmail;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);
        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);
        edRePassword = findViewById(R.id.edRePassword);
        edName = findViewById(R.id.edName);
        edGmail = findViewById(R.id.edGmail);
        btnCancel = findViewById(R.id.btnCancel);

        chkRememberPass = findViewById(R.id.chkRememberPass);
        loginDangnhap = findViewById(R.id.btnAddUser);
        loginDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAO = new UserDAO(AddUserActivity.this);
                User user = new User(edUserName.getText().toString(),
                        edPassWord.getText().toString(),
                        edRePassword.getText().toString(),
                        edName.getText().toString(),
                        edGmail.getText().toString());
                try {
                    if (validateForm() > 0) {
                        if (userDAO.insertUser(user) > 0) {
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
        });

    }
    public int validateForm() {
        int check = 1;
        if (edUserName.getText().length() == 0 ||
                edPassWord.getText().length() == 0 ||
                edRePassword.getText().length() == 0 ||
                edName.getText().length() == 0 ||
                edGmail.getText().length() == 0) {
            Toast.makeText(this, "Bạn phải nhập đủ thông tin ", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPassWord.getText().toString();
            String repass = edRePassword.getText().toString();
            if (!pass.equals(repass)) {
                Toast.makeText(this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }


}


