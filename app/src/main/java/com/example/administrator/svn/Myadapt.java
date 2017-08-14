package com.example.administrator.svn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/11.
 */

public class Myadapt extends BaseAdapter {
    Context context;
    ArrayList<String> list;

    public Myadapt(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
                 if ( convertView==null){
                            convertView=View.inflate(context,R.layout.item11,null) ;
                     viewholder=new ViewHolder();
                     viewholder.tv1= (TextView) convertView.findViewById(R.id.tvtv11);
                     convertView.setTag(viewholder);
                 }else {
                      viewholder= (ViewHolder) convertView.getTag();
                         }
                viewholder.tv1.setText(list.get(position));
                return convertView;
            }
            class ViewHolder{
                TextView tv1;
            }
}
