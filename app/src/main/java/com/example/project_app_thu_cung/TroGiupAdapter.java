package com.example.project_app_thu_cung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TroGiupAdapter extends RecyclerView.Adapter<TroGiupAdapter.TroGiupViewHolder> {
    Context context;
    List<TroGiup> list;

    public TroGiupAdapter(Context context, List<TroGiup> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TroGiupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_buoc, parent, false);

        return new TroGiupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TroGiupViewHolder holder, int position) {
        TroGiup troGiup = list.get(position);
        if(troGiup == null) {
            return;
        }
        holder.buoc.setText(troGiup.getBuoc()+ "");
        holder.chitiet.setText(troGiup.getChitiet()+ "");
    }

    @Override
    public int getItemCount() {
        if(list != null) {
            return list.size();
        }
        return 0;
    }

    public class TroGiupViewHolder extends RecyclerView.ViewHolder {
        TextView buoc, chitiet;
        public TroGiupViewHolder(@NonNull View itemView) {
            super(itemView);

            buoc = itemView.findViewById(R.id.buoc);
            chitiet = itemView.findViewById(R.id.chitiet);
        }
    }
}
