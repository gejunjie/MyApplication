package com.srcb.moper.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.srcb.moper.myapplication.scroller.TestView;


public class MainActivity extends AppCompatActivity {

    private Button scrollerButton;

    private Button intentButton;

    private RelativeLayout relativeLayout;

    private TestView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayoutInflaterTest();
        rxjava();
        initScrollerTest();

    }

    private void initLayoutInflaterTest() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.button_layout,null);
        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.addView(view);
    }

    private void initScrollerTest() {
        intentButton = findViewById(R.id.button);

        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        scrollerButton = findViewById(R.id.scroll_button);
        view = findViewById(R.id.scroller_test);
        scrollerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.scrollBy(-1*10,-1*10);
            }
        });
    }

    void rxjava(){
        RxJavaTest.just();
        RxJavaTest.assembly();
    }
}
