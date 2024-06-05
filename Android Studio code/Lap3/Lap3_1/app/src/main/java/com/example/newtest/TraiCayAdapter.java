package com.example.newtest;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class TraiCayAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<trai_cay> traiCayList;
    public TraiCayAdapter(Context context, int layout, List<trai_cay> traiCayList){
        this.context =context;
        this.layout= layout;
        this.traiCayList=traiCayList;
    }
    @Override
    public int getCount(){ // tra ve so dong hien thi tren listview
        //return 0;
        return traiCayList.size();
    }
    @Override
    public Objects getItem(int i){
        return  null;
    }
    @Override
    public  long getItemId(int i){
        return  0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){// tra ve view moi dong tren item khi goi adapter
        LayoutInflater inflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        //anh xa view
        TextView txtTen = (TextView) view.findViewById(R.id.tvTen);
        TextView txtMota = (TextView) view.findViewById(R.id.tvMoTa);
        ImageView imageHinh = (ImageView) view.findViewById(R.id.imageViewHinh);

        //gan gia tri
        trai_cay traiCay = traiCayList.get(i);
        txtTen.setText(traiCay.getTen());
        txtMota.setText(traiCay.getMota());
        imageHinh.setImageResource(traiCay.qetHinh());

        return  view;
    }
}
