package com.example.administrator.svn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%AB%98%E6%99%93%E6%9D%BE&bk_length=600";
    private ImageView img11;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fram2, null);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        Okhttpss.getInstence().getInternet(url, new Okhttpss.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(ss, Bean.class);
                Glide.with(getActivity()).load(bean.getImage()).error(R.mipmap.ic_launcher).into(img11);

            }
        });

    }

    private void initView(View view) {
        img11 = (ImageView) view.findViewById(R.id.img11);
    }
}
