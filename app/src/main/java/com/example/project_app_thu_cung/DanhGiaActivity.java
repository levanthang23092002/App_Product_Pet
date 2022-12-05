package com.example.project_app_thu_cung;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DanhGiaActivity extends AppCompatActivity {
    RecyclerView danhgia_rcv;
    DanhGiaAdapter danhGiaAdapter;
    List<danhgiamodel> list;

    TextView tatcasao;
    LinearLayout motsao, haisao, basao, bonsao, namsao;

    FirebaseDatabase fdb = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia);

        initID();

        danhgia_rcv = findViewById(R.id.danhgia_rcv);
        danhgia_rcv.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        danhGiaAdapter = new DanhGiaAdapter(this, list);
        danhgia_rcv.setAdapter(danhGiaAdapter);


        fdb.getReference().child("danhgia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    danhgiamodel danhgiamodel = dataSnapshot.getValue(danhgiamodel.class);
                    list.add(danhgiamodel);
                }
                danhGiaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        motsao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                Query data = fdb.getReference("danhgia").orderByChild("sao").equalTo(1);
                data.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        danhgiamodel danhgiamodel = snapshot.getValue(com.example.project_app_thu_cung.danhgiamodel.class);
                        list.add(danhgiamodel);
                        danhGiaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        haisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                Query data = fdb.getReference("danhgia").orderByChild("sao").equalTo(2);
                data.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        danhgiamodel danhgiamodel = snapshot.getValue(com.example.project_app_thu_cung.danhgiamodel.class);
                        list.add(danhgiamodel);
                        danhGiaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        basao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                Query data = fdb.getReference("danhgia").orderByChild("sao").equalTo(3);
                data.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        danhgiamodel danhgiamodel = snapshot.getValue(com.example.project_app_thu_cung.danhgiamodel.class);
                        list.add(danhgiamodel);
                        danhGiaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        bonsao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                Query data = fdb.getReference("danhgia").orderByChild("sao").equalTo(4);
                data.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        danhgiamodel danhgiamodel = snapshot.getValue(com.example.project_app_thu_cung.danhgiamodel.class);
                        list.add(danhgiamodel);
                        danhGiaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        namsao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                Query data = fdb.getReference("danhgia").orderByChild("sao").equalTo(5);
                data.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        danhgiamodel danhgiamodel = snapshot.getValue(com.example.project_app_thu_cung.danhgiamodel.class);
                        list.add(danhgiamodel);
                        danhGiaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        tatcasao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                Query data = fdb.getReference("danhgia").orderByChild("sao");
                data.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        danhgiamodel danhgiamodel = snapshot.getValue(com.example.project_app_thu_cung.danhgiamodel.class);
                        list.add(danhgiamodel);
                        danhGiaAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }

    public void initID() {
        motsao = findViewById(R.id.motsao);
        haisao = findViewById(R.id.haisao);
        basao = findViewById(R.id.basao);
        bonsao = findViewById(R.id.bonsao);
        namsao = findViewById(R.id.namsao);
        tatcasao = findViewById(R.id.tatcasao);
    }

    public void clear() {
        list.clear();
        danhGiaAdapter.notifyDataSetChanged();
    }
}