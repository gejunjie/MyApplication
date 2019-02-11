package com.srcb.moper.myapplication.okhttp;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 定义一个应用拦截器，用于在请求发送前打印URL以及接受到响应后打印内容。
 * Created by Gjj on 2018/12/19.
 */
public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.i("okhttp",request.toString());
        Response response = chain.proceed(request);
        Log.i("okhttp",response.toString());
        return response;
    }
}
