package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Thong_tin_ca_nhan extends AppCompatActivity implements ValueEventListener {
    private TextView txtten,txtngsing,txtgt,txtsdt,txtdiachi;
    private ImageButton btn_ve;
    private ImageView menu;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference ref= db.getReference();


    Uri imageUri;
    ProgressDialog progressDialog ;
    StorageReference storageReference ;
    Button btn_choose_img, btn_save_img;
    ImageView my_img;

    private DatabaseReference diachi=ref.child(apunti.sdt).child("user").child("diachi");
    private DatabaseReference gioitinh =ref.child(apunti.sdt).child("user").child("gioitinh");
    private DatabaseReference hoten =ref.child(apunti.sdt).child("user").child("hoten");
    private DatabaseReference ngaysinh=ref.child(apunti.sdt).child("user").child("ngaysinh");
    private DatabaseReference sdt =ref.child(apunti.sdt).child("user").child("sdt");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        btn_ve = findViewById(R.id.btn_ttcn_back);
        txtten =(TextView) findViewById(R.id.txthoten);
        txtngsing =(TextView) findViewById(R.id.txtngaysinh);
        txtgt =(TextView) findViewById(R.id.txtgioitinh);
        txtsdt =(TextView) findViewById(R.id.txtsdt);
        txtdiachi =(TextView) findViewById(R.id.txtdiachi);
        menu =findViewById(R.id.menu);

        btn_choose_img = findViewById(R.id.btn_choose_image);
        btn_save_img = findViewById(R.id.btn_save_image);
        my_img = (ImageView)findViewById(R.id.image_informationUser);

        ref = FirebaseDatabase.getInstance().getReference();
       // Toast.makeText(Thong_tin_ca_nhan.this,apunti.sdt,Toast.LENGTH_SHORT).show();
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thong_tin_ca_nhan.this,Out_main.class);
                startActivity(intent);
            }
        });

        btn_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });

        btn_choose_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectImage();
            }
        });
        btn_save_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadImage();
            }
        });

        btn_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        if (snapshot.getValue(String.class)!=null){
            String key =snapshot.getKey();
            if(key.equals("hoten")){
                String khoahoc =snapshot.getValue(String.class);
                txtten.setText(khoahoc);
            }
            if(key.equals("gioitinh")){
                String khoahoc =snapshot.getValue(String.class);
                txtgt.setText(khoahoc);
            }
            if(key.equals("sdt")){
                String khoahoc =snapshot.getValue(String.class);
                txtsdt.setText(khoahoc);
            }
            if(key.equals("diachi")){
                String khoahoc =snapshot.getValue(String.class);
                txtdiachi.setText(khoahoc);
            }
            if(key.equals("ngaysinh")){
                String khoahoc =snapshot.getValue(String.class);
                txtngsing.setText(khoahoc);
            }
        }
    }
    @Override
    public void onCancelled(@NonNull DatabaseError error) {


    }
    @Override
    protected void onStart() {
        super.onStart();
        hoten.addValueEventListener(this);
        gioitinh.addValueEventListener(this);
        diachi.addValueEventListener(this);
        ngaysinh.addValueEventListener(this);
        sdt.addValueEventListener(this);

    }
    public void openlogin(){
        Intent intent = new Intent(this ,Home.class);
        startActivity(intent);
    }

    private void SelectImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 100);
    }
    private void UploadImage(){

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("uploading File...");
        progressDialog.show();

        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now = new Date();
        String filename = format.format(now);
        storageReference = FirebaseStorage.getInstance().getReference("images/" + filename);

        storageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                my_img.setImageURI(imageUri);
                Toast.makeText(Thong_tin_ca_nhan.this,"Successfully Uploaded" , Toast.LENGTH_SHORT).show();
                if(progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                if(progressDialog.isShowing())
                    progressDialog.dismiss();
                Toast.makeText(Thong_tin_ca_nhan.this,"Failed to Upload" , Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && data != null && data.getData() != null){
            imageUri = data.getData();
            my_img.setImageURI(imageUri);
        }
    }

}