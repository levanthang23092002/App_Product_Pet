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

public class ShoppingCartActivity extends AppCompatActivity {

    RecyclerView rc ;
    GioHangAdapter mainAdapter;
    private ImageView btn_ve;
    private DatabaseReference ref;
    private FirebaseDatabase db;
    private CheckBox ck_tong;
    private GioHang gioHang;
    private Button muahang;
    private List<GioHang> gioHangList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        UI();
        getlistsp();
        btn_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ShoppingCartActivity.this,Home.class);
                startActivity(intent);
            }
        });
        muahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ShoppingCartActivity.this,Mua_hang.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bt  = findViewById(R.id.bottom_nav);
        bt.setSelectedItemId(R.id.cart);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mes:
                        Intent hom = new Intent(ShoppingCartActivity.this,Home.class);
                        startActivity(hom);
                        break;
                    case R.id.account:
                        Intent acc = new Intent(ShoppingCartActivity.this,Lichsu.class);
                        startActivity(acc);
                        break;
                    case R.id.cart:
                        break;
                    case R.id.note:
                        Intent thongbao = new Intent(ShoppingCartActivity.this,Vi_Tk.class);
                        startActivity(thongbao);
                        break;
                }

                return true;
            }
        });
    }
    private void UI(){
        rc =(RecyclerView) findViewById(R.id.lvGioHang);
        ck_tong=findViewById(R.id.ck_tong);
        muahang = findViewById(R.id.btn_muahang);
        btn_ve=findViewById(R.id.id_comback_login);

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
                Toast.makeText(ShoppingCartActivity.this,"get list false",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
