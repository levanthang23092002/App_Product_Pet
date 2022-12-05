package com.example.project_app_thu_cung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyviewHolder>  {

    private List<GioHang> list;

    public GioHangAdapter(List<GioHang> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_shopping_cart,parent,false);
        return new MyviewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        GioHang gioHang= list.get(position);
        holder.tensp.setText(gioHang.getTen());
        Glide.with(holder.hinhanh.getContext())
                .load(gioHang.getHinhanh())
                .placeholder(R.mipmap.ic_launcher) // ảnh mặt định
                .circleCrop()
                .error(R.mipmap.ic_launcher) // ảnh khi lỗi
                .into(holder.hinhanh);
        holder.phanloai.setText(gioHang.getPhanloai());
        holder.soluong.setText(gioHang.getSoluong());
        holder.tongtien.setText(gioHang.getTongtien());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView tensp, soluong, phanloai, tongtien;
        ImageView hinhanh;
        LinearLayout the;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tensp = itemView.findViewById(R.id.textviewTensp);
            soluong = itemView.findViewById(R.id.textviewsoluong);
            phanloai =itemView.findViewById(R.id.textviewsize);
            the = itemView.findViewById(R.id.the);
            hinhanh = itemView.findViewById(R.id.imgGioHang);
            tongtien =itemView.findViewById(R.id.textviewtongtien);
        }
    }
}
