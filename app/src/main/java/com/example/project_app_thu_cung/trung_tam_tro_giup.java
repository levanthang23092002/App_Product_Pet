package com.example.project_app_thu_cung;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class trung_tam_tro_giup extends Fragment {


    LinearLayout cauhoi1, cauhoi2, cauhoi3, cauhoi4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trung_tam_tro_giup, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cauhoi1 = view.findViewById(R.id.cauhoi1);
        cauhoi2 = view.findViewById(R.id.cauhoi2);
        cauhoi3 = view.findViewById(R.id.cauhoi3);
        cauhoi4 = view.findViewById(R.id.cauhoi4);

        cauhoi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TroGiupChiTietActivity.class);
                Bundle bundle = new Bundle();
                List<String> a = new ArrayList<>();
                a.add("Chó th");
                a.add("Chó th2");
                a.add("Chó th3");
                a.add("Chó th4");
                String[] arr = new String[a.size()];
                arr = a.toArray(arr);
                bundle.putStringArray("a", arr);

                getContext().startActivity(intent);
            }
        });

    }

    public void gotoDetail() {

    }
}
