package com.srcb.moper.myapplication.srcbTest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.srcb.moper.myapplication.R;
import com.srcb.moper.myapplication.service.MyService;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private Button button2;
//    private Button button3;

    private Button startService;
    private Button stopService;
    private Button bindService;
    private Button unbindService;

    private TextView textView;
    Handler handler = new Handler();
    Handler handler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            textView.setText(String.valueOf(msg.arg1));
        }
    };

    private MyService.MyBinder myBinder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            myBinder.done();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        Intent intent = new Intent();
        intent.setAction("com.tengxun.aidl");//service的action
        intent.setPackage("qdx.aidlserver");//aidl文件夹里面aidl文件的包名
//        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        textView = findViewById(R.id.text);
        textView.post(new Runnable() {
            @Override
            public void run() {

            }
        });
        startService = findViewById(R.id.button4);
        startService.setOnClickListener(this);
        stopService = findViewById(R.id.button5);
        stopService.setOnClickListener(this);
        bindService = findViewById(R.id.button6);
        bindService.setOnClickListener(this);
        unbindService = findViewById(R.id.button7);
        unbindService.setOnClickListener(this);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
//        button3 = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setText2();
            }
        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
////                        Looper.prepare();
////                        Looper.loop();
////                        //不建议这么做，会导致内存泄露，线程无法结束
////                        Toast.makeText(HandlerActivity.this,"在线程中的toast",Toast.LENGTH_LONG).show();
//                    }
//                }).start();
//
//            }
//        });
//        runOnUiThread();
    }

    private void setText2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Message message = new Message();
                Message message = Message.obtain();
                message.arg1 = 111;
//                handler2.dispatchMessage(message);
                handler2.sendMessage(message);

            }
        }).start();
    }

    private void setText() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("1111111完成");
                    }
                };
                handler.post(r);//Runnale在主线程执行
            }
        }).start();
//        new Thread(){/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                Intent intent = new Intent(HandlerActivity.this,MyService.class);
                startService(intent);
                break;
            case R.id.button5:
                Intent intent1 = new Intent(this,MyService.class);
                stopService(intent1);
                break;
            case R.id.button6:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.button7:
                unbindService(serviceConnection);
        }
    }
}
