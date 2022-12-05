package com.example.project_app_thu_cung;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterOut extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Out> arraylist;

    public AdapterOut(Context context, int layout, List<Out> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        Out out = arraylist.get(position);

        TextView tv_out =  convertView.findViewById(R.id.tv_out);
        ImageView img_out = convertView.findViewById(R.id.img_out);

        tv_out.setText(out.getTenchucnang());
        img_out.setImageResource(out.getHinh());
        return convertView;
    }
}

