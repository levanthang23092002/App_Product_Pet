package com.example.project_app_thu_cung;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterSanphan extends RecyclerView.Adapter<AdapterSanphan.SPViewHoler> {
    Context context;
    private List<SanPham> listlsp;
    private Onclickitem onclickitem;

    public AdapterSanphan(Context context, List<SanPham> listlsp) {
        this.context = context;
        this.listlsp = listlsp;
    }
    Home mainActivity = new Home();
    public AdapterSanphan(List<SanPham> listlsp, Onclickitem onclickitem) {
        this.listlsp = listlsp;
        this.onclickitem = onclickitem;
        notifyDataSetChanged();
    }

    public AdapterSanphan(List<SanPham> listlsp) {
        this.listlsp = listlsp;
    }

    @NonNull
    @Override
    public SPViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listout,parent,false);
        return new SPViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SPViewHoler holder, int position) {
        SanPham SP = listlsp.get(position);
        if(SP == null){
            return;
        }
        holder.tvname.setText(SP.getTensp());
        holder.tvmota.setText( SP.getMota());
        holder.tvprice.setText( SP.getGia());
        Glide.with(holder.hinh.getContext())
                .load(SP.getHinh())
                .placeholder(R.mipmap.ic_launcher) // ảnh mặt định
                .circleCrop()
                .error(R.mipmap.ic_launcher) // ảnh khi lỗi
                .into(holder.hinh);
        holder.tvid.setText(SP.getId());
    }

    @Override
    public int getItemCount() {
        if (listlsp != null){
            return listlsp.size();
        }
        return 0;
    }

    public class SPViewHoler  extends RecyclerView.ViewHolder {
        private TextView tvname;
        private ContactsContract.CommonDataKinds.Note note;
        private TextView tvmota;
        private TextView tvprice;
        private TextView tvid;
        private ImageView hinh;
        public SPViewHoler(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickitem.onItemClick(chi_tiet_san_pham.class);
                }
            });
            tvname = itemView.findViewById(R.id.tv_name);
            tvmota = itemView.findViewById(R.id.tv_mota);
            tvprice = itemView.findViewById(R.id.tv_price);
            hinh = itemView.findViewById(R.id.imgsp);
            tvid=itemView.findViewById(R.id.txt_id);
        }
    }
}

