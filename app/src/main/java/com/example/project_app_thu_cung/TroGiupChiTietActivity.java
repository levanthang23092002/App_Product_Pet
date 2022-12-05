package com.example.project_app_thu_cung;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TroGiupChiTietActivity extends AppCompatActivity {
    RecyclerView trogiup_rcv;
    List<TroGiup> list;
    TroGiupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tro_giup_chi_tiet);

        trogiup_rcv = findViewById(R.id.trogiup_rcv);
        list = new ArrayList<>();
        adapter = new TroGiupAdapter(this, list);
        trogiup_rcv.setLayoutManager(new LinearLayoutManager(this));
        trogiup_rcv.setAdapter(adapter);

        Bundle bundle = getIntent().getExtras();

        String[] arr = bundle.getStringArray("a");
        for(int i=0; i < arr.length; i++) {
            list.add(new TroGiup(arr[i], i));
        }


    }




}