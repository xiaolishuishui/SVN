package com.example.administrator.svn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    //String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%AB%98%E6%99%93%E6%9D%BE&bk_length=600";
    private String wapUrl="http://wapbaike.baidu.com/item/%E9%AB%98%E6%99%93%E6%9D%BE/431523";
    private WebView webView;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fram3,null);
      webView= (WebView) view.findViewById(R.id.web);
        webView.loadUrl(wapUrl);
        return view;
    }

/*    private void initData() {
        Okhttpss.getInstence().getInternet(url, new Okhttpss.CallBacks() {
            @Override
            public void getString(String ss) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(ss, Bean.class);
                wapUrl = bean.getWapUrl();

            }
        });
    }

    private void initWebview() {
         WebView webView=new WebView(getActivity());

                 webView.loadUrl(wapUrl);

    }*/

}
