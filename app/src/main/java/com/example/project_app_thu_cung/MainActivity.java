package com.example.project_app_thu_cung;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    TextView txtsdt,txtmatkhau,txtnhaplaimatkhau,txtdanhnhap;
    Button btndangki;
    ImageButton btnfb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS
        }, PackageManager.PERMISSION_GRANTED);

        txtsdt = findViewById(R.id.txtsdt);
        txtdanhnhap = findViewById(R.id.txtDangnhap);
        txtmatkhau =findViewById(R.id.txtmatkhau);
        txtnhaplaimatkhau= findViewById(R.id.txtnhapmatkhaulai);

        btndangki = findViewById(R.id.btndangki);
        btnfb= findViewById(R.id.btnfacebook);
        btndangki.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View view) {
                String pass1,con1;
                pass1= txtmatkhau.getText().toString().trim();
                con1=txtnhaplaimatkhau.getText().toString().trim();
                // ktra xem nhập đầy đủ thông tin hay chưa
                if( txtsdt.getText().toString().equals("") || txtmatkhau.getText().toString().equals("")|| txtnhaplaimatkhau.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "not allowed Null!!", Toast.LENGTH_SHORT).show();
                } else if (pass1 .equals(con1)) {
                    try {


                        Random rd = new Random();// khai báo random
                        int x = 111111 + (int) (Math.random() * (999999 - 111111) + 1);//random

                        String maOTP = String.valueOf(x);// chuyển int->string
                        String SMS = "Mã OTP của bạn là " + maOTP; // tạo SMS để gửi tn
                        String number = txtsdt.getText().toString(); // lấy sô dth nhập vào
                        SmsManager sm = SmsManager.getSmsManagerForSubscriptionId(Integer.parseInt("0966948914"));
                        sm.sendTextMessage(number, null, SMS, null, null);
                        Toast.makeText(MainActivity.this, "gửi thành công", Toast.LENGTH_SHORT).show();

                        String matkhau = txtmatkhau.getText().toString();
                        String sdt = txtsdt.getText().toString();
                        String nhaplaimatkhau = txtnhaplaimatkhau.getText().toString();

                        apunti.sdt = sdt;
                        apunti.matkhau = matkhau;
                        apunti.maotp = x;

                        openMaOTP();
                    }catch (ArithmeticException e)
                    {
                        Toast.makeText(MainActivity.this, "Số Điện Thoại ko Tôn Tại", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "PassWord and Confirm must be equal!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtdanhnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void openMaOTP(){
        Intent intent = new Intent(this ,MaOTP.class);
        startActivity(intent);
    }
    public void opendanhnhap(){
        Intent intent = new Intent(this ,login.class);
        startActivity(intent);
    }
}