package com.srcb.moper.myapplication.okhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/**
 * 拦截器可以添加、移除或者替换请求的头信息，也可以改变传输的主体部分。下面的一个拦截器对请求主体进行Gzip压缩。
 * Created by Gjj on 2018/12/19.
 */
public class GzipRequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null){
            return chain.proceed(originalRequest);
        }

        Request compressedRequest = originalRequest.newBuilder()
                .header("Content-Enoding","gizp")
                .method(originalRequest.method(),gizp(originalRequest.body()))
                .build();
        return chain.proceed(compressedRequest);
    }

    private RequestBody gizp(final RequestBody body) {
        return new RequestBody() {
//            @javax.annotation.Nullable
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public long contentLength() throws IOException {
                return -1;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                BufferedSink bufferedSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(bufferedSink);
                bufferedSink.close();
            }
        };
    }
}
