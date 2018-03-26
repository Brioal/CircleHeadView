package com.brioal.circleheadview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.brioal.circlehead.CircleHead;

public class MainActivity extends AppCompatActivity {

    private CircleHead mCircleHead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircleHead = findViewById(R.id.main_head);
        //测试设置
        mCircleHead.setText("A");
        mCircleHead.setRandom(true);
        mCircleHead.setBackColor(Color.RED).setTextColor(Color.YELLOW);
    }
}
