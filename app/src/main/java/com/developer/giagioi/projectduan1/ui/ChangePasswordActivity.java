package com.developer.giagioi.projectduan1.ui;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.User;
import com.developer.giagioi.projectduan1.sqlitedao.UserDAO;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText edNewPass;
    private EditText edRePassword;
    private Button btnSave;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        edNewPass = findViewById(R.id.edNewPass);
        edRePassword = findViewById(R.id.edRePassword);
        btnSave = findViewById(R.id.btnSave);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
                String strUserName = pref.getString("USERNAME", "");
                userDAO = new UserDAO(ChangePasswordActivity.this);
                User user = new User(strUserName, edNewPass.getText().toString(),"","","");
                try {
                    if (validateForm() > 0) {
                        if (userDAO.changePasswordUser(user) > 0) {
                            Toast.makeText(getApplicationContext(), "Lưu thành công",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Lưu thất bại",
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
        if (edNewPass.getText().length() == 0 || edRePassword.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edNewPass.getText().toString();
            String rePass = edRePassword.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp",
                        Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }
}
