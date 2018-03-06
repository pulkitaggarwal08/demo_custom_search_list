package com.demo_searchview_customlist.pulkit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by param on 15/12/2015.
 */
public class CustomAdapter extends BaseAdapter {

    private Context contex;
    List<String> list;

    public CustomAdapter(Context context, List<String> lstFound) {
        this.contex = context;
        this.list = lstFound;
    }

    @Override
    public int getCount() {
//        return list.length;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
//        return list[position];
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {

        public TextView textViewName;
        public ImageView imageView;
        public TextView textViewDescription;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        LayoutInflater layoutInflater = (LayoutInflater) contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_item, null);

            viewHolder = new ViewHolder();

            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_image);
            viewHolder.textViewName = (TextView) convertView.findViewById(R.id.textview_Name);
            viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.textview_Description);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        String rowItems = list[position];
//        viewHolder.textViewName.setText(rowItems);

        String row = (String) getItem(position);
        viewHolder.textViewName.setText(row);

        return convertView;
    }

}
