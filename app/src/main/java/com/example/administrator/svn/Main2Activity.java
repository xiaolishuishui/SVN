package com.example.administrator.svn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends Activity implements View.OnClickListener {

    private ViewPager viewpager;
    private View view_dot1;
    private View view_dot2;
    private View view_dot3;
    private LinearLayout ll_dot;
    private View view_dot;
    private RelativeLayout Rl_dot;
    private int doubl;
    private List<View> list = new ArrayList<>();
    private MyAdper myAdper;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initDate();
        getleng();
        myAdper = new MyAdper();
        viewpager.setAdapter(myAdper);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if (viewpager.getCurrentItem() == 2) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            btn.setVisibility(View.VISIBLE);
                            ll_dot.setVisibility(View.GONE);
                            view_dot.setVisibility(View.GONE);
                        }
                    });
                }

            }
        }, 100, 100);
    }

    private void initDate() {
        View view1 = View.inflate(Main2Activity.this, R.layout.view1, null);
        View view2 = View.inflate(Main2Activity.this, R.layout.view2, null);
        View view3 = View.inflate(Main2Activity.this, R.layout.view3, null);
        list.add(view1);
        list.add(view2);
        list.add(view3);


//        list1.add(new Bean("hello",R.mipmap.ic_launcher,1));
//        list1.add(new Bean("hello",0,2));
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setCurrentItem(0);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        view_dot1 = (View) findViewById(R.id.view_dot1);
        view_dot2 = (View) findViewById(R.id.view_dot2);
        view_dot3 = (View) findViewById(R.id.view_dot3);
        ll_dot = (LinearLayout) findViewById(R.id.ll_dot);
        view_dot = (View) findViewById(R.id.view_dot);
        Rl_dot = (RelativeLayout) findViewById(R.id.Rl_dot);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                float cc = doubl * positionOffset + doubl * position;
                RelativeLayout.LayoutParams bb = (RelativeLayout.LayoutParams) view_dot.getLayoutParams();
                bb.leftMargin = (int) cc;
                view_dot.setLayoutParams(bb);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //     initTab();


    }

    public void getleng() {
        ViewTreeObserver sObserver = ll_dot.getViewTreeObserver();
        sObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                doubl = ll_dot.getChildAt(1).getLeft() - ll_dot.getChildAt(0).getLeft();
            }
        });
    }

//    private void initTab() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
//                            if (viewpager.getCurrentItem() == 4) {
//                                viewpager.setCurrentItem(0);
//                            }
//                        }
//                    });
//                    // myAdper.notifyDataSetChanged();
//                }
//
//            }
//        }).start();
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
             //   Toast.makeText(this, "１２３４５６", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                break;
        }
    }

    private class MyAdper extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }
}
