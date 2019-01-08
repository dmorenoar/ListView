package com.example.dmorenoar.listview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapterGrid extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> listNames;


    public MyAdapterGrid(Context context, int layout, List<String> listNames){
        this.context = context;
        this.layout = layout;
        this.listNames = listNames;
    }

    @Override
    public int getCount() {
        return this.listNames.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView != null) {

            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();

            holder.nameTextView = (TextView) convertView.findViewById(R.id.textViewGrid);
            //holder.img = (Image) convertView.findViewById(R.id.imageGrid);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        String currentName = listNames.get(position);
        holder.nameTextView.setText(currentName);


        return convertView;
    }


    static class ViewHolder {
        private TextView nameTextView;
        private Image img;
    }
}
