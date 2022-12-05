package com.example.project_app_thu_cung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DanhGiaAdapter extends RecyclerView.Adapter<DanhGiaAdapter.DanhGiaViewHolder> {
    Context context;
    List<danhgiamodel> danhgiaList;

    public DanhGiaAdapter(Context context, List<danhgiamodel> danhgiaList) {
        this.context = context;
        this.danhgiaList = danhgiaList;
    }

    @NonNull
    @Override
    public DanhGiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_danhgia, parent, false);

        return new DanhGiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhGiaViewHolder holder, int position) {
        danhgiamodel danhgia = danhgiaList.get(position);
        if(danhgia == null) {
            return;
        }

        holder.ten.setText(danhgia.getTen());
        holder.thoigian.setText(danhgia.getThoigian());
        holder.noidung.setText(danhgia.getNoidung());
    }

    @Override
    public int getItemCount() {
        if(danhgiaList != null) {
            return danhgiaList.size();
        }
        return 0;
    }

    public class DanhGiaViewHolder extends RecyclerView.ViewHolder {
        TextView ten, thoigian, noidung;

        public DanhGiaViewHolder(@NonNull View itemView) {
            super(itemView);
            ten = itemView.findViewById(R.id.ten);
            thoigian = itemView.findViewById(R.id.thoigian);
            noidung = itemView.findViewById(R.id.noidung);
        }
    }
}
