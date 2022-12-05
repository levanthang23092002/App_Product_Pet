package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
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

public class Vi_Tk extends AppCompatActivity {
    TextView txtnamestk,txtnamemapin,txtnamebank;
    EditText txtstk,txtmapin;
    Spinner txtbank;
    Button btnthem,btnan;
    ImageButton btnadd,btntrove;
    RecyclerView lv_vi;
    AdapterVi mainAdapter;
    List<vi_them> viList;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_tk);
        anhsa();
        Ui();


        btnan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienthi();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               themtk();
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    mDatabase = FirebaseDatabase.getInstance().getReference();
                    String stk =txtstk.getText().toString();
                    String mapin =txtmapin.getText().toString();
                    String bank = txtbank.getSelectedItem().toString();
                    if(stk.equals("")||mapin.equals("")||bank.equals("")){
                        oppendialog_tb(Gravity.CENTER,"Bạn cần nhập đầy đủ thông tin");
                    }else{
                        vi_them vi = new vi_them(stk,bank,mapin);

                        mDatabase.child(apunti.sdt).child("vi").push().setValue(vi);
                        hienthi();

                    }
                }

            });
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome();
            }
        });

        BottomNavigationView bt  = findViewById(R.id.bottom_nav);
        bt.setSelectedItemId(R.id.note);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.mes:
                        Intent hom = new Intent(Vi_Tk.this,Home.class);
                        startActivity(hom);
                        break;
                    case R.id.account:
                        Intent acc = new Intent(Vi_Tk.this,Lichsu.class);
                        startActivity(acc);
                        break;
                    case R.id.cart:
                        Intent giohang = new Intent(Vi_Tk.this,ShoppingCartActivity.class);
                        startActivity(giohang);
                        break;
                    case R.id.note:
                        break;
                }

                return true;
            }
        });

    }
    private void anhsa(){
        ref = FirebaseDatabase.getInstance().getReference();
        txtnamestk =findViewById(R.id.txt_vi_namestk);
        txtnamemapin = findViewById(R.id.txt_vi_namemaping);
        txtnamebank= findViewById(R.id.txt_vi_namebank);
        txtstk =findViewById(R.id.txt_vi_stkhoan);
        txtmapin =findViewById(R.id.txt_vi_maping);
        txtbank=findViewById(R.id.cbb_vi_bank);
        btnthem = findViewById(R.id.btn_vi_them);
        btnan= findViewById(R.id.btn_vi_an);
        btnadd =findViewById(R.id.btn_vi_add);
        lv_vi =findViewById(R.id.lv_vi_tkbank);
        btntrove= findViewById(R.id.btn_vi_trove);
    }
    private void Ui(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lv_vi.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        lv_vi.addItemDecoration(dividerItemDecoration);

        viList= new ArrayList<>();
        mainAdapter = new AdapterVi(viList);
        lv_vi.setAdapter(mainAdapter);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference(apunti.sdt).child("vi");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    vi_them vi = dataSnapshot.getValue(vi_them.class);
                    viList.add(vi);
                }
                mainAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Vi_Tk.this,"get list false",Toast.LENGTH_SHORT).show();
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
                openhome();
            }
        });
        txtcontent.setText(x);
        dialog.show();
    }


    public void openhome(){
        Intent intent = new Intent(this ,Home.class);
        startActivity(intent);
    }

    private void themtk(){
        txtnamestk.setVisibility(View.VISIBLE);
        txtnamemapin.setVisibility(View.VISIBLE);
        txtnamebank.setVisibility(View.VISIBLE);
        txtstk.setVisibility(View.VISIBLE);
        txtmapin.setVisibility(View.VISIBLE);
        txtbank.setVisibility(View.VISIBLE);
        btnthem.setVisibility(View.VISIBLE);
        btnan.setVisibility(View.VISIBLE);
        lv_vi.setVisibility(View.INVISIBLE);
    }
    private void hienthi(){
        txtnamestk.setVisibility(View.INVISIBLE);
        txtnamemapin.setVisibility(View.INVISIBLE);
        txtnamebank.setVisibility(View.INVISIBLE);
        txtstk.setVisibility(View.INVISIBLE);
        txtmapin.setVisibility(View.INVISIBLE);
        txtbank.setVisibility(View.INVISIBLE);
        btnthem.setVisibility(View.INVISIBLE);
        btnan.setVisibility(View.INVISIBLE);
        lv_vi.setVisibility(View.VISIBLE);
    }

}