package com.example.project_app_thu_cung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChiTietSanPhamAdapter extends RecyclerView.Adapter<ChiTietSanPhamAdapter.ChiTietSanPhamViewHolder>{
    Context context;
    List<chiTietSanPhamModel> chiTietList;

    public ChiTietSanPhamAdapter(Context context, List<chiTietSanPhamModel> chiTietList) {
        this.context = context;
        this.chiTietList = chiTietList;
    }

    @NonNull
    @Override
    public ChiTietSanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_ct_san_pham, parent, false);
        return new ChiTietSanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChiTietSanPhamAdapter.ChiTietSanPhamViewHolder holder, int position) {
        chiTietSanPhamModel chiTietSanPhamModel = chiTietList.get(position);
        if(chiTietSanPhamModel == null){
            return;
        }
    }

    @Override
    public int getItemCount() {
        if(chiTietList != null){
            return chiTietList.size();
        }
        return 0;
    }

    public class ChiTietSanPhamViewHolder extends  RecyclerView.ViewHolder{
        TextView tv_ten, tv_mota, tv_gia, tv_sizeS, tv_sizeM, tv_sizeL, tv_sizeXL, tv_sao;

        public ChiTietSanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ten = itemView.findViewById(R.id.txt_detail_name);
            tv_mota = itemView.findViewById(R.id.txt_detail_mota);
            tv_gia = itemView.findViewById(R.id.txt_detail_gia);
            tv_sizeS = itemView.findViewById(R.id.txt_detail_sizeS);
            tv_sizeM = itemView.findViewById(R.id.txt_detail_sizeM);
            tv_sizeL = itemView.findViewById(R.id.txt_detail_sizeXL);
            tv_sizeXL = itemView.findViewById(R.id.txt_detail_sizeXL);
            tv_sao = itemView.findViewById(R.id.img_detail_danhgia);
        }
    }
}
