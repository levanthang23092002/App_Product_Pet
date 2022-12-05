package com.example.project_app_thu_cung;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Out_main extends AppCompatActivity {

    ListView lv_out;
    ArrayList<Out> arrayList;
    AdapterOut adapterOut;
    ImageButton btn_back;
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstancrState){
        super.onCreate(savedInstancrState);
        setContentView(R.layout.nav_header);
        lv_out = (ListView) findViewById(R.id.lv_outt);
        arrayList = new ArrayList<>();
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Out_main.this,Home.class);
                startActivity(intent);
            }
        });

        arrayList.add(new Out("Đơn hàng của tôi",R.drawable.ic_baseline_document_scanner_24));
        arrayList.add(new Out("Ví",R.drawable.ic_baseline_wallet_24));
        arrayList.add(new Out("Trung tâm hỗ trợ",R.drawable.ic_baseline_help_outline_24));
        arrayList.add(new Out("Đăng xuất",R.drawable.ic_baseline_login_24));
        adapterOut = new AdapterOut( Out_main.this,R.layout.activity_out, arrayList);
        lv_out.setAdapter(adapterOut);
        lv_out.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent();
                    intent.setClass(Out_main.this,Lichsu.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent();
                    intent.setClass(Out_main.this,Vi_Tk.class);
                    startActivity(intent);
                }

                if(position==2){
                    Intent intent = new Intent();
                    intent.setClass(Out_main.this,TrungTamHoTro.class);

                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent();
                    intent.setClass(Out_main.this,login.class);
                    startActivity(intent);
                }
            }
        });
    }
}