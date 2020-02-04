package com.customdrawer.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.customdrawer.app.adpater.MenuAdapterWOM;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button btnWithOutMode, btnWithMode;
    ImageView btn_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_main);
        context = this;
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setVisibility(View.GONE);
        btnWithOutMode = findViewById(R.id.btnWithOutMode);
        btnWithMode = findViewById(R.id.btnWithMode);
        btnWithOutMode.setOnClickListener(this);
        btnWithMode.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btnWithOutMode) {
            Intent i = new Intent(context, MainActivityWOM.class);
            startActivity(i);
        } else if (v == btnWithMode) {
            Intent i = new Intent(context, MainActivityWM.class);
            startActivity(i);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
