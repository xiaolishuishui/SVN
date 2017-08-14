package com.example.administrator.svn;

import android.os.Handler;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/26.
 */
// okhttp的 单例模式get方式的封装
public class Okhttpss {
    private volatile static Okhttpss okhttpss;
    private OkHttpClient client;
    private Handler handler;
///////////////////单例模式保证该方法 只能在同一时间使用统一对象。////////////////
    public  static synchronized Okhttpss getInstence(){
        if (okhttpss==null){
            okhttpss=new Okhttpss();
        }
        return okhttpss;
    }
 //////////////////////////构造方法////////////////////////////////////////////////
   public Okhttpss(){
        this.handler=new Handler();
        this.client=new OkHttpClient();
    }
///////////////////////创建接口是为了实现异步请求///////////////////////////////////
    public interface CallBacks{
        void getString(String ss);
}

    public  void getInternet(String url, final CallBacks cllBacks){
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("====="+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result= response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        cllBacks.getString(result);
                    }
                });
            }
        });



    }

}
/*
Okhttpss.getInstence().getInternet(url, new Okhttpss.CallBacks() {
@Override
public void getString(String ss) {
        System.out.println(ss+"======");
        Toast.makeText(MainActivity.this, ss, Toast.LENGTH_SHORT).show();
        }
        });*/
