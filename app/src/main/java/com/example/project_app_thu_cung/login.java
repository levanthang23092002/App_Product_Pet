package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class login extends AppCompatActivity {
    private LinearLayout txtdangki_dn;
    EditText txtsdt, txtpass;
    Button btndangnhap;
    Sqlite sqlite;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference ref= db.getReference();
    boolean status = false;


    private DatabaseReference sdt;
    private DatabaseReference pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();


        //tạo cơ sở dữ liệu
        sqlite = new Sqlite(this,"user.sqlite", null,1);
        // tạo bảng  user(sdt,pass)
        sqlite.QueryData("CREATE TABLE IF NOT EXISTS User(sdt INTEGER PRIMARY KEY ,pass VARCHAR(200))");
        //sqlite.QueryData("delete from User");

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangnhap();
            }
        });
        txtdangki_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oppenDangki();
            }
        });
    }
    private void oppenDangki(){
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
    }
    private void dangnhap(){
        if (txtpass.getText().toString().equals("")||txtsdt.getText().toString().equals("")){
            oppendialog_tb(Gravity.CENTER,"Vui Lòng Nhập Đầy Đủ Số Tài Khoản Và Pass");
        }else{
                Cursor data1 = sqlite.getdata("SELECT * From User");
                while (data1.moveToNext() == true) {
                    int sdt = data1.getInt(0);
                    String pass = data1.getString(1);
                    String user = txtsdt.getText().toString().trim();
                    apunti.sdt =user;
                    int User = Integer.valueOf(user);
                    if (User == sdt && txtpass.getText().toString().equals(pass)) {
                        Toast.makeText(login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this, Home.class);
                        intent.putExtra("user", txtsdt.getText().toString());
                        startActivity(intent);
                        txtpass.setText("");
                        txtsdt.setText("");
                        status = true;
                        break;
                    }
                }
                if (!data1.moveToNext() && !status) {
                    Toast.makeText(login.this, "Sai thông tin tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }


    }
    private void anhxa(){
        txtsdt =findViewById(R.id.txtsdt_dn);
        txtpass =findViewById(R.id.txtmatkhau_dn);
        btndangnhap =findViewById(R.id.btndannhap);
        txtdangki_dn = findViewById(R.id.txtDangki_dn);
    }
    private void oppendialog_tb(int gravity,String x){
        final Dialog dialog =new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.diglog_ntt);
        Window window = dialog.getWindow();
        if(window ==null)   {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowactibu = window.getAttributes();
        windowactibu.gravity=gravity;
        window.setAttributes(windowactibu);
        if(Gravity.BOTTOM==gravity){
            dialog.setCancelable(true);
        }
        else {
            dialog.setCancelable(false);
        }
        EditText txtcontent =dialog.findViewById(R.id.txt_dialog_content);
        Button btnyes =dialog.findViewById(R.id.btn_diglog_yes);
        Button btnno =dialog.findViewById(R.id.btn_diglogn_No);

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        txtcontent.setText(x);
        dialog.show();
    }



}