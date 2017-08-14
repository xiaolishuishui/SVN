package com.example.administrator.svn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment {


    private RecyclerView recy;
    String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%AB%98%E6%99%93%E6%9D%BE&bk_length=600";
ArrayList<Bean.CardBean> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fram1, null);
        initView(view);
        initData();

        return view;
    }

    private void initData() {
        Okhttpss.getInstence().getInternet(url, new Okhttpss.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson=new Gson();
                Bean bean = gson.fromJson(ss, Bean.class);
                List<Bean.CardBean> card = bean.getCard();

                for (int i = 0; i < card.size(); i++) {
                    list.add(card.get(i));
                    System.out.println(card.get(i).getName()+"========");
                }
                //设置布局方式
                recy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

                Myadapter adapter=new Myadapter(getActivity(),list);


                recy.setAdapter(adapter);


            }
        });



    }

    private void initView(View view) {
        recy = (RecyclerView) view.findViewById(R.id.recy);
    }
}
