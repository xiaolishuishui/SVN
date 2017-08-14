package com.example.administrator.svn;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%AB%98%E6%99%93%E6%9D%BE&bk_length=600";
    private Myview myview;
    private ListView lv;
    private FrameLayout framlayout;
    ArrayList<String> list=new ArrayList<>();
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;
    private BlankFragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        if (fragment1 == null) {
            fragment1 = new BlankFragment1();
            transaction.add(R.id.framlayout, fragment1);
        } else {
            transaction.show(fragment1);
        }
        transaction.commit();


    }

    private void initData() {
        list.add("个人简述");
        list.add("个人照片");
        list.add("更多内容");
        Myadapt myadapt=new Myadapt(Main3Activity.this,list);
        lv.setAdapter(myadapt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //动态添加Fragment
                //获取Fragment 管理器
                FragmentManager msg = getSupportFragmentManager();
                //开启Fragment事物
                FragmentTransaction transaction = msg.beginTransaction();
                //方法2隐藏所有的Fragment。
                hideAll(transaction);


                switch (position){
                    case 0:
                        if (fragment1 == null) {
                            fragment1 = new BlankFragment1();
                            transaction.add(R.id.framlayout, fragment1);
                        } else {
                            transaction.show(fragment1);
                        }
                        break;
                    case 1:
                        if (fragment2 == null) {
                            fragment2 = new BlankFragment2();
                            transaction.add(R.id.framlayout, fragment2);
                        } else {
                            transaction.show(fragment2);
                        }
                        break;
                    case 2:
                        if (fragment3 == null) {
                            fragment3 = new BlankFragment3();
                            transaction.add(R.id.framlayout, fragment3);
                        } else {
                            transaction.show(fragment3);
                        }
                        break;
                }
                transaction.commit();
            }
        });



    }

    private void hideAll(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        } if (fragment3 != null) {
            transaction.hide(fragment3);
        }


    }

    private void initView() {
        myview = (Myview) findViewById(R.id.myview);
        lv = (ListView) findViewById(R.id.lv);
        framlayout = (FrameLayout) findViewById(R.id.framlayout);
        myview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "这是自定义view", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

