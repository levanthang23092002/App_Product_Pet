package com.example.project_app_thu_cung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TrungTamHoTro extends AppCompatActivity {
    LinearLayout cauhoi1, cauhoi2, cauhoi3, cauhoi4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trung_tam_ho_tro);
        cauhoi1 = findViewById(R.id.cauhoi1);
        cauhoi2 = findViewById(R.id.cauhoi2);
        cauhoi3 = findViewById(R.id.cauhoi3);
        cauhoi4 = findViewById(R.id.cauhoi4);

        cauhoi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrungTamHoTro.this, TroGiupChiTietActivity.class);
                Bundle bundle = new Bundle();
                List<String> a = new ArrayList<>();
                a.add("Chó th");
                a.add("Chó th2");
                a.add("Chó th3");
                a.add("Chó th4");
                String[] arr = new String[a.size()];
                arr = a.toArray(arr);
                bundle.putStringArray("a", arr);

                startActivity(intent);
            }
        });
    }
}