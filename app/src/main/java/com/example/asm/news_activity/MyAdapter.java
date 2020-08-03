package com.example.asm.news_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asm.R;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Item> {
    Context context;
    ArrayList<Item> items;

    public MyAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inf = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inf.inflate(R.layout.layout_tintheoloai_itemlistview, parent, false);
        TextView tv_title = (TextView) convertView.findViewById(R.id.title);
        TextView tv_description = (TextView) convertView.findViewById(R.id.description);
        TextView tv_pubdate = (TextView) convertView.findViewById(R.id.pubdate);

        tv_title.setText(items.get(position).getTitle());
//        tv_description.setText(items.get(position).getDescription());
        tv_pubdate.setText(items.get(position).getPubdate());

        return convertView;

    }
}
