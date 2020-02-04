package com.customdrawer.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDemo1 extends AppCompatActivity implements View.OnClickListener {

    Context context;
    ImageView btn_menu, btn_back;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        context = this;

        initView();
        tvTitle.setText("Demo1");
    }

    private void initView() {
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setVisibility(View.GONE);
        tvTitle= findViewById(R.id.tvTitle);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setVisibility(View.VISIBLE);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_back) {
            finish();
        }
    }

}
