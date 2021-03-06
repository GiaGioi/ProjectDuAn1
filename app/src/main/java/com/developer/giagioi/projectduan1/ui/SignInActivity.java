package com.developer.giagioi.projectduan1.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.User;
import com.developer.giagioi.projectduan1.sqlitedao.UserDAO;

public class SignInActivity extends AppCompatActivity {

    private Button btnsignin;
    private Button btnsignup;
    private EditText edUserName;
    private EditText edPassWord;
    private CheckBox chkRememberPass;
    private Button loginDangnhap;
    public String strUser, strPass;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);
        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);
        chkRememberPass = findViewById(R.id.chkRememberPass);
        loginDangnhap = findViewById(R.id.login_dangnhap);
        restore();
        edUserName.setText("admin");
        edPassWord.setText("admin");
        userDAO = new UserDAO(SignInActivity.this);

        User user = new User("admin", "admin", "admin", "Nguyễn Gia Gioi","gioingph05882@fpt.edu.vn");
        userDAO.insertUser(user);

        loginDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strUser = edUserName.getText().toString().trim();
                strPass = edPassWord.getText().toString().trim();
                User us = userDAO.getUser(strUser);
                boolean check = chkRememberPass.isChecked();

                if (strUser.isEmpty() || strPass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được bỏ trống",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String oPass = us.getPassWord();
                    String o = us.getUserName();
                    if (userDAO.checkLogin(strUser, strPass) > 0) {
                        Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
                    }
                    if (strUser.equalsIgnoreCase("admin") && strPass.equalsIgnoreCase("admin")) {
                        rememberUser(strUser, strPass, check);
                        Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
                    } else if(o.equals(strUser) && oPass.equals(strPass)) {
                        rememberUser(strUser, strPass, check);
                        Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không đúng",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }

    public void rememberUser(String u, String p, boolean status) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (!status) {
            //xoa tinh trang luu tru truoc do
            edit.clear();
        } else {
            //luu du lieu
            edit.putString("USERNAME", u);
            edit.putString("PASSWORD", p);
            edit.putBoolean("REMEMBER", status);
        }
        //luu lai toan bo
        edit.commit();
    }

    public void restore() {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        boolean check = pref.getBoolean("REMEMBER", false);
        if (check) {
            String user = pref.getString("USERNAME", "");
            String pass = pref.getString("PASSWORD", "");
            edUserName.setText(user);
            edPassWord.setText(pass);
        }
        chkRememberPass.setChecked(check);
    }
}


