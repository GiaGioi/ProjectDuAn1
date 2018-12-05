package com.developer.giagioi.projectduan1.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.developer.giagioi.projectduan1.R;
import com.developer.giagioi.projectduan1.model.User;
import com.developer.giagioi.projectduan1.sqlitedao.UserDAO;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.oob.SignUp;

public class SignUpActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 007;

    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;

    private Button btnsignin;
    private Button btnsignup;
    private EditText edgmail;
    private EditText edUserName;
    private EditText edPassWord;
    private CheckBox chkRememberPass;
    private Button loginDangnhap;
    private Button btn_sign_in;
    private ProgressBar progressBar;
    UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);
        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);
        btn_sign_in =findViewById(R.id.btn_sign_in);
        chkRememberPass = findViewById(R.id.chkRememberPass);
        loginDangnhap = findViewById(R.id.login_dangnhap);


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,GoogleActivity.class));
            }
        });
        loginDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserName.getText().toString().trim();
                String password = edPassWord.getText().toString().trim();


                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được bỏ trống",
                            Toast.LENGTH_SHORT).show();
                } else {
                    String oPass = edPassWord.getText().toString().trim();
                    String o = edUserName.getText().toString().trim();
                    if (edUserName != null && edPassWord != null) {
                        Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                    }
                    if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
                        rememberUser(username, password);
                        finish();
                        startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                    } else if (o.equals(username) && oPass.equals(password)) {
                        rememberUser(username, password);
                        finish();
                        startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không đúng",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    public void rememberUser(String u, String p) {
        SharedPreferences pref = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
//        if (!status) {
//            //xoa tinh trang luu tru truoc do
//            edit.clear();
//        } else {
//            //luu du lieu
//            edit.putString("USERNAME", u);
//            edit.putString("PASSWORD", p);
//
//        }
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