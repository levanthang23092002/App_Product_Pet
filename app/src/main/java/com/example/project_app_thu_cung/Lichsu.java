package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Lichsu extends AppCompatActivity {
    RecyclerView rc ;
    GioHangAdapter mainAdapter;
    private ImageView btn_ve;
    private DatabaseReference ref;
    private FirebaseDatabase db;

    private List<GioHang> gioHangList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsu);
        ref = FirebaseDatabase.getInstance().getReference();
        UI();
        getlistsp();
        btn_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Lichsu.this,Home.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bt  = findViewById(R.id.bottom_nav);
        bt.setSelectedItemId(R.id.account);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mes:
                        Intent hom = new Intent(Lichsu.this,Home.class);
                        startActivity(hom);
                        break;
                    case R.id.account:
                        break;
                    case R.id.cart:
                        Intent acc = new Intent(Lichsu.this,ShoppingCartActivity.class);
                        startActivity(acc);
                        break;
                    case R.id.note:
                        Intent thongbao = new Intent(Lichsu.this,Vi_Tk.class);
                        startActivity(thongbao);
                        break;
                }

                return true;
            }
        });
    }
    private void UI(){
        rc =(RecyclerView) findViewById(R.id.lvLichsu);
        btn_ve=findViewById(R.id.id_lichsu_login);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rc.addItemDecoration(dividerItemDecoration);

        gioHangList= new ArrayList<>();
        mainAdapter = new GioHangAdapter(gioHangList);
        rc.setAdapter(mainAdapter);


    }
    private void getlistsp(){
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("giohang").child(apunti.sdt)  ;
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    GioHang loaiSP = dataSnapshot.getValue(GioHang.class);
                    gioHangList.add(loaiSP);
                }
                mainAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Lichsu.this,"get list false",Toast.LENGTH_SHORT).show();
            }
        });
    }

}