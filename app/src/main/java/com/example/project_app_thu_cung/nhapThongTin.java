package com.example.project_app_thu_cung;

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
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class nhapThongTin extends AppCompatActivity {
    Sqlite sqlite;
    private Spinner txt_gioitinh,txt_diachi;
   private Button btnxacnhan;
   private EditText txt_hten,txt_ngaysinh;
    private TextView txt_trove;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_thong_tin);
        //tạo cơ sở dữ liệu
        sqlite = new Sqlite(this,"user.sqlite", null,1);
        //sqlite.QueryData("Drop Table User");
        // tạo bảng  user(sdt,pass)
        sqlite.QueryData("CREATE TABLE IF NOT EXISTS User(sdt INTEGER PRIMARY KEY ,pass VARCHAR(200))");
        sqlite.QueryData("delete from User");
        anhxa();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apunti.hoten =txt_hten.getText().toString();
                apunti.ngaysinh =txt_ngaysinh.getText().toString();
                apunti.diachi=txt_diachi.getSelectedItem().toString();
                apunti.gioitinh=txt_gioitinh.getSelectedItem().toString();
                if(txt_hten.getText().toString().equals("")||txt_ngaysinh.getText().toString().equals("")||txt_diachi.getSelectedItem().toString().equals("")||txt_gioitinh.getSelectedItem().toString().equals("")){
                    oppendialog_tb(Gravity.CENTER,"Bạn cần nhập đầy đủ thông tin");
                }else{
                    String sql ="INSERT INTO User VALUES("+apunti.sdt+",'"+apunti.matkhau+"')";
                    sqlite.QueryData(sql);
                    taikhoan tk = new taikhoan(apunti.sdt,apunti.matkhau,apunti.hoten,apunti.gioitinh,apunti.ngaysinh,apunti.diachi);
                    mDatabase.child(apunti.sdt).child("user").setValue(tk);
                    Cursor data1 = sqlite.getdata("SELECT * From User");
                    while(data1.moveToNext()== true){
                        int sdt = data1.getInt(0);
                        String pass =data1.getString(1);
                        Toast.makeText(nhapThongTin.this,pass, Toast.LENGTH_SHORT).show();
                        openlogin();

                    }

                    }
                }
        });
        txt_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendangki();
            }
        });
    }

     //có thể sử dụng lại
    private  void anhxa(){
        txt_hten = findViewById(R.id.txt_ntt_hoten);
        txt_ngaysinh = findViewById(R.id.txt_ntt_ngaysinh);
        txt_diachi = findViewById(R.id.txt_ntt_diachi);
        txt_trove =findViewById(R.id.txt_ntt_trove);
        txt_gioitinh = (Spinner) findViewById(R.id.cbb_ntt_gtinh);
        btnxacnhan = findViewById(R.id.btn_ntt_xacnhan);
        txt_trove =findViewById(R.id.txt_ntt_trove);

    }
     private void oppendialog_finish(int gravity){
         final Dialog dialog =new Dialog(this);
         dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         dialog.setContentView(R.layout.diglog_finish);
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
         }// bấm nút khác vẫn ko thoát ra

         ImageButton btnexit =dialog.findViewById(R.id.btn_dfinish_exit);

         btnexit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openhome();
             }
         });

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
                openlogin();
            }
        });
       txtcontent.setText(x);
        dialog.show();
      }
    public void openlogin(){
        Intent intent = new Intent(this ,login.class);
        startActivity(intent);
    }
    public void openhome(){
        Intent intent = new Intent(this ,Home.class);
        startActivity(intent);
    }
    public void opendangki(){
        Intent intent = new Intent(this ,MainActivity.class);
        startActivity(intent);
    }


}