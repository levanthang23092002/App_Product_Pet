package com.example.project_app_thu_cung;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MaOTP extends AppCompatActivity {
    private DatabaseReference mDatabase;
    TextView txtguima;
    Button btnxacnhan;
    EditText txtmacode1,txtmacode2,txtmacode3,txtmacode4,txtmacode5,txtmacode6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_otp);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        ActivityCompat.requestPermissions(MaOTP.this, new String[]{
                Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS
        }, PackageManager.PERMISSION_GRANTED);


         txtguima =findViewById(R.id.txtguilaima);
         btnxacnhan=findViewById(R.id.btnxacnhan);
         txtmacode1=findViewById(R.id.macode1);
         txtmacode2=findViewById(R.id.macode2);
         txtmacode3=findViewById(R.id.macode3);
         txtmacode4=findViewById(R.id.macode4);
         txtmacode5=findViewById(R.id.macode5);
         txtmacode6=findViewById(R.id.macode6);




         txtguima.setOnClickListener(new View.OnClickListener(){

             @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
             @Override
             public void onClick(View view) {

                 Random rd=new Random();
                 int x=111111+(int)(Math.random()*(999999-111111)+1);
                 String maOTP = String.valueOf(x) ;
                 String SMS = "Mã OTP của bạn là " + maOTP;
                 String number = apunti.sdt;
                 SmsManager sm = SmsManager.getSmsManagerForSubscriptionId(Integer.parseInt("0966948914"));
                 sm.sendTextMessage(number, null,SMS, null, null);
                 apunti.maotp = x;
                 txtmacode1.setText("");//các số thứ 1 nhập vào
                 txtmacode2.setText("");
                 txtmacode3.setText("");
                 txtmacode4.setText("");
                 txtmacode5.setText("");
                 txtmacode6.setText("");
             }
         });
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x =apunti.maotp;
                String so1 =txtmacode1.getText().toString();//các số thứ 1 nhập vào
                String so2 =txtmacode2.getText().toString();//các số thứ 2 nhập vào
                String so3 =txtmacode3.getText().toString();//các số thứ 3 nhập vào
                String so4 =txtmacode4.getText().toString();//các số thứ 4 nhập vào
                String so5 =txtmacode5.getText().toString();//các số thứ 5 nhập vào
                String so6 =txtmacode6.getText().toString();//các số thứ 6 nhập vào

                int s1 =Integer.valueOf(so1);// chuyển String -> int
                int s2 =Integer.valueOf(so2);// chuyển String -> int
                int s3 =Integer.valueOf(so3);// chuyển String -> int
                int s4 =Integer.valueOf(so4);// chuyển String -> int
                int s5 =Integer.valueOf(so5);// chuyển String -> int
                int s6 =Integer.valueOf(so6);// chuyển String -> int
                // ktra các số trong mã OTP
                if (s1==x/100000){
                    s1=s1*100000;
                    x=x-s1;
                    if (s2==x/10000){
                        s2=s2*10000;
                        x=x-s2;
                        if (s3==x/1000){
                            s3=s3*1000;
                            x=x-s3;
                            if (s4==x/100){
                                s4=s4*100;
                                x=x-s4;
                                if (s5==x/10){
                                    s5=s5*10;
                                    x=x-s5;
                                    if (s6==x){
                                        Toast.makeText(MaOTP.this, "Bạn đã đăng kí thành công", Toast.LENGTH_SHORT).show();
                                        openinputinformation();
                                    }else {Toast.makeText(MaOTP.this, "Mã Không chính sác6", Toast.LENGTH_SHORT).show();}
                                }else {Toast.makeText(MaOTP.this, "Mã Không chính sác5", Toast.LENGTH_SHORT).show();}
                            }else {Toast.makeText(MaOTP.this, "Mã Không chính sác4", Toast.LENGTH_SHORT).show();}
                        }else {Toast.makeText(MaOTP.this, "Mã Không chính sác3", Toast.LENGTH_SHORT).show();}
                    }else {Toast.makeText(MaOTP.this, "Mã Không chính sác2", Toast.LENGTH_SHORT).show();}
                }else {Toast.makeText(MaOTP.this, "Mã Không chính sác1", Toast.LENGTH_SHORT).show();}



            }
        });
    }
    public void openinputinformation(){
        Intent intent = new Intent(this ,nhapThongTin.class);
        startActivity(intent);}


}