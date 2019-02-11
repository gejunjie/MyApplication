package com.srcb.moper.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.srcb.moper.myapplication.okhttp.LogInterceptor;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initHkHttp();

    }

    private void initHkHttp() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
       // 拦截器运行了两次。一次是初始请求”http://www.taobao.com“，一次是请求重定向”https://www.taobao.com“。
//                .addNetworkInterceptor(new LogInterceptor())
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url("http://www.taobao.com")
                .get().build();
        Call call = client.newCall(request);
        //同步方式
//        try {
//            Response response = call.execute();
//            Log.i("okhttp", response.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //异步方式
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.i("okhttp",response.toString());
                ResponseBody response1 = response.body();
            }
        });
    }

}
