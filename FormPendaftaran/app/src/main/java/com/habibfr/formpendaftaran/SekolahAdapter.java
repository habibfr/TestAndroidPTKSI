package com.habibfr.formpendaftaran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SekolahAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sekolah> sekolahArrayList = new ArrayList<>();

    public SekolahAdapter(Context context, ArrayList<Sekolah> sekolahArrayList) {
        this.context = context;
        this.sekolahArrayList = sekolahArrayList;
    }

    @Override
    public int getCount() {
        return sekolahArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return sekolahArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return sekolahArrayList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.sekolah_item, viewGroup, false);
        Sekolah curent = sekolahArrayList.get(i);

        TextView txtNamaSekolah = view.findViewById(R.id.txtNamaSekolah);
        txtNamaSekolah.setText(curent.getNamaSekolah().toString().trim());
//        serialNum = convertView.findViewById(R.id.serailNumber);
//        name = convertView.findViewById(R.id.studentName);
//        contactNum = convertView.findViewById(R.id.mobileNum);
//        serialNum.setText(" " + arrayList.get(position).getNum());
//        name.setText(arrayList.get(position).getName());
//        contactNum.setText(arrayList.get(position).getMobileNumber());
        return view;

    }
}
