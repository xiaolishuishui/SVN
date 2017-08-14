package com.example.administrator.svn;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/1.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    Context context;
    ArrayList<Bean.CardBean> list;

    public Myadapter(Context context, ArrayList<Bean.CardBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item1, null);
        ViewHolder viewholder = new ViewHolder(view);

        return viewholder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv1.setText(list.get(position).getName());
        holder.tv2.setText(list.get(position).getValue().get(0));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;
        TextView tv2;

        public ViewHolder(View itemView) {

            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.fram_tv1);
            tv2 = (TextView) itemView.findViewById(R.id.fram_tv2);
        }
    }
}
