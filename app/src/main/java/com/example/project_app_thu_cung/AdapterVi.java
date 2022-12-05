package com.example.project_app_thu_cung;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterVi extends  RecyclerView.Adapter<AdapterVi.viViewHoler>{
    private List<vi_them> listlsp;
    private Onclickitem onclickitem;

    public AdapterVi(List<vi_them> listlsp, Onclickitem onclickitem) {
        this.listlsp = listlsp;
        this.onclickitem = onclickitem;
        notifyDataSetChanged();
    }

    public AdapterVi(List<vi_them> listlsp) {
        this.listlsp = listlsp;
    }

    @NonNull
    @Override
    public viViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vi,parent,false);
        return new AdapterVi.viViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viViewHoler holder, int position) {
        vi_them vi =listlsp.get(position);
        if(vi == null){
            return;
        }
         holder.txtbank.setText(vi.getBank());
         holder.txtstk.setText(vi.getStk());

    }

    @Override
    public int getItemCount() {
        if (listlsp != null){
            return listlsp.size();
        }
        return 0;
    }

    public class viViewHoler extends RecyclerView.ViewHolder {
        TextView txtstk,txtbank;
        public viViewHoler(@NonNull View itemView) {
            super(itemView);

            txtstk = itemView.findViewById(R.id.txt_itemvi_stk);
            txtbank= itemView.findViewById(R.id.txt_itemvi_bank);

        }
    }
}
