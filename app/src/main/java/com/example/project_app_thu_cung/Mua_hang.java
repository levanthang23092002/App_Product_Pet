package com.example.project_app_thu_cung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Mua_hang extends AppCompatActivity {
    ImageView btn_comback;
    TextView ten,phanloai,sluong,tongtien;
    Button btnmua;
    private DatabaseReference ref1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_hang);
        ten=findViewById(R.id.textviewTensp);
        phanloai=findViewById(R.id.textviewsize);
        sluong=findViewById(R.id.textviewsoluong);
        tongtien=findViewById(R.id.textviewtongtien);
        btnmua =findViewById(R.id.btn_dathang);
        btnmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rd = new Random();// khai báo random
                int x = 111111 + (int) (Math.random() * (999999 - 111111) + 1);
                String X =String.valueOf(x);
                ref1 = FirebaseDatabase.getInstance().getReference();
                GioHang tk = new GioHang(Spdamua.ten,Spdamua.phanloai,Spdamua.soluong,Spdamua.hinhanh,Spdamua.tongtien,X);
                ref1.child("hangdamua").child(apunti.sdt).push().setValue(tk);
                Intent intent =new Intent(Mua_hang.this,Lichsu.class);
                startActivity(intent);
            }
        });

        ten.setText(Spdamua.ten);
        phanloai.setText(Spdamua.phanloai);
        sluong.setText(Spdamua.soluong);
        tongtien.setText(Spdamua.tongtien);

        btn_comback=findViewById(R.id.img_muahang_comback);
        btn_comback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hom = new Intent(Mua_hang.this,Home.class);
                startActivity(hom);
            }
        });

    }
}