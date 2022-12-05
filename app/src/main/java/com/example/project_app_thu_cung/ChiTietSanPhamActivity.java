package com.example.project_app_thu_cung;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class ChiTietSanPhamActivity extends AppCompatActivity implements ValueEventListener {
    ImageButton btn_trove;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Button btncong, btntru, btnmuahang, btngiohang;
    TextView soluong;
    ImageView img_dg;
    ImageView product;
    TextView Gia, ten,mota,sizem,sizes,sizel,sizmxl,sosao;

    private DatabaseReference ref1;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference ref= db.getReference();

    private DatabaseReference hinh=ref.child("SanPham").child("Phukien").child("Phukien_4").child("hinh");
    private DatabaseReference gia=ref.child("SanPham").child("Phukien").child("Phukien_4").child("gia");
    private DatabaseReference mota1=ref.child("SanPham").child("Phukien").child("Phukien_4").child("mota");
    private DatabaseReference tensp=ref.child("SanPham").child("Phukien").child("Phukien_4").child("tensp");
    private DatabaseReference Sosao=ref.child("SanPham").child("Phukien").child("Phukien_4").child("sosao");
    private DatabaseReference m=ref.child("SanPham").child("Phukien").child("Phukien_4").child("sizeM");
    private DatabaseReference l=ref.child("SanPham").child("Phukien").child("Phukien_4").child("sizeL");
    private DatabaseReference s=ref.child("SanPham").child("Phukien").child("Phukien_4").child("sizeS");
    private DatabaseReference xl=ref.child("SanPham").child("Phukien").child("Phukien_4").child("sizexl");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_san_pham);


        anhsa();

        btnmuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spdamua.ten=ten.getText().toString();
                Spdamua.soluong=soluong.getText().toString();
                String sl = soluong.getText().toString();
                int k =Integer.valueOf(sl);
                int gia =Integer.valueOf(Spdamua.tongtien);
                int tien = k * gia;
                String Tongtien =String.valueOf(tien);
                Spdamua.tongtien =Tongtien;
                Random rd = new Random();// khai báo random
                int x = 111111 + (int) (Math.random() * (999999 - 111111) + 1);
                String X =String.valueOf(x);
                Intent intent =new Intent(ChiTietSanPhamActivity.this,Mua_hang.class);
                startActivity(intent);
            }
        });
        img_dg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(ChiTietSanPhamActivity.this, DanhGiaActivity.class);
                startActivity(intent5);
            }
        });
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sl = soluong.getText().toString();
                int i = Integer.valueOf(sl);
                if (i <= 1) {
                    Toast.makeText(ChiTietSanPhamActivity.this, "Chọn ít nhất 1 sản phẩm", Toast.LENGTH_SHORT).show();
                } else {
                    i = i - 1;
                    sl = String.valueOf(i);
                    soluong.setText(sl);
                }
            }
        });
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sl = soluong.getText().toString();
                int i = Integer.valueOf(sl);
                i = i + 1;
                sl = String.valueOf(i);
                soluong.setText(sl);
            }
        });
        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietSanPhamActivity.this, Home.class);
                startActivity(intent);
            }
        });

        btngiohang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Spdamua.ten=ten.getText().toString();
                Spdamua.soluong=soluong.getText().toString();
                String sl = soluong.getText().toString();
                int k =Integer.valueOf(sl);
                int gia =Integer.valueOf(Spdamua.tongtien);
                int tien = k * gia;
                String Tongtien =String.valueOf(tien);
                Spdamua.tongtien =Tongtien;
                Random rd = new Random();// khai báo random
                int x = 111111 + (int) (Math.random() * (999999 - 111111) + 1);
                String X =String.valueOf(x);

                Spdamua.hinhanh ="https://firebasestorage.googleapis.com/v0/b/projectappthucung.appspot.com/o/phu_kien_4.jpg?alt=media&token=350f6ce0-195f-4213-998b-f459032fa839";
                    ref1 = FirebaseDatabase.getInstance().getReference();
                    GioHang tk = new GioHang(Spdamua.ten,Spdamua.phanloai,Spdamua.soluong,Spdamua.hinhanh,Spdamua.tongtien,X);
                    ref1.child("giohang").child(apunti.sdt).push().setValue(tk);

                Intent intent =new Intent(ChiTietSanPhamActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }

    private void anhsa() {
        btn_trove = findViewById(R.id.btn_detail_trove);
        radioGroup = findViewById(R.id.radio_btn);
        btncong = findViewById(R.id.btn_detail_cong);
        btntru = findViewById(R.id.btn_detail_tru);
        soluong = findViewById(R.id.txt_detail_soluong);
        img_dg = findViewById(R.id.img_detail_danhgia);
        btnmuahang = findViewById(R.id.btn_detail_muahang);

        product = findViewById(R.id.image_detail_product);
        Gia =findViewById(R.id.txt_detail_gia);
        ten =findViewById(R.id.txt_detail_name);
        mota =findViewById(R.id.txt_detail_mota);
        sizem= findViewById(R.id.txt_detail_sizeM);
        sizes =findViewById(R.id.txt_detail_sizeS);
        sizel = findViewById(R.id.txt_detail_sizeL);
        sizmxl= findViewById(R.id.txt_detail_sizeXL);
        sosao =findViewById(R.id.txt_detail_sodanhgia);

        btngiohang =findViewById(R.id.btn_detail_giohang);
        Spdamua.phanloai ="S";

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radio_1 :
                        Spdamua.phanloai ="S";
                        break;
                    case R.id.radio_2 :
                        Spdamua.phanloai ="M";
                        break;
                    case R.id.radio_3 :
                        Spdamua.phanloai ="L";
                        break;
                    case R.id.radio_4 :
                        Spdamua.phanloai ="XL";
                        break;
                }
            }
        });



    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if (snapshot.getValue(String.class)!=null){
            String key =snapshot.getKey();
            if(key.equals("hinh")){
                Glide.with(product.getContext())
                        .load(hinh)
                        .placeholder(R.mipmap.ic_launcher) // ảnh mặt định
                        .circleCrop()
                        .error(R.mipmap.ic_launcher) // ảnh khi lỗi
                        .into(product);
            }
            if(key.equals("gia")){
                String khoahoc =snapshot.getValue(String.class);
                Gia.setText(khoahoc+"Vnđ");
                Spdamua.tongtien=khoahoc;

            }
            if(key.equals("mota")){
                String khoahoc =snapshot.getValue(String.class);
                mota.setText(khoahoc);
            }
            if(key.equals("tensp")){
                String khoahoc =snapshot.getValue(String.class);
                ten.setText(khoahoc);
            }
            if(key.equals("sosao")){
                String khoahoc =snapshot.getValue(String.class);
                sosao.setText(khoahoc);
            }
            if(key.equals("sizeM")){
                String khoahoc =snapshot.getValue(String.class);
                sizem.setText("Size M"+khoahoc);
            }
            if(key.equals("sizeL")){
                String khoahoc =snapshot.getValue(String.class);
                sizel.setText("Size L"+khoahoc);
            }
            if(key.equals("sizeS")){
                String khoahoc =snapshot.getValue(String.class);
                sizes.setText("Size M"+khoahoc);
            }
            if(key.equals("sizexl")){
                String khoahoc =snapshot.getValue(String.class);
                sizmxl.setText("Size XL"+khoahoc);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
    protected void onStart() {
        super.onStart();
        hinh.addValueEventListener(this);
        gia.addValueEventListener(this);
        mota1.addValueEventListener(this);
        tensp.addValueEventListener(this);
        Sosao.addValueEventListener(this);
        m.addValueEventListener(this);
        l.addValueEventListener(this);
        s.addValueEventListener(this);
        xl.addValueEventListener(this);



    }
}