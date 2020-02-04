package com.customdrawer.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.customdrawer.app.adpater.MenuAdapterWM;

import java.util.ArrayList;
import java.util.List;

public class MainActivityWM extends AppCompatActivity implements MenuAdapterWM.GetIdFromMenuAdapter, View.OnClickListener {

    List<MenuItems> listMenuItem = new ArrayList<>();
    MenuAdapterWM menuAdapter;
    Context context;
    RecyclerView rcNavMenu;
    ImageView btn_menu;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_menu);
        context = this;
        drawer = findViewById(R.id.drawer_layout);
        rcNavMenu = findViewById(R.id.rcNavMenu);
        btn_menu = findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(this);

        inflateMenuItems();
        inflateAdapter();
    }

    private void inflateAdapter() {
        menuAdapter = new MenuAdapterWM(context, listMenuItem, this);
        rcNavMenu.setAdapter(menuAdapter);

    }

    //C=> Category not clickable
    //L=> Draws only separator
    //I=> Items
    private void inflateMenuItems() {
        listMenuItem.add(new MenuItems("1", "Categories", "", "C"));
        listMenuItem.add(new MenuItems("2", "All Categories", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("3", "My Order History", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("4", "My Cart", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("5", "My Wishlist", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("6", "My Account", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("8", "Bridal", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("9", "Denims", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("10", "Ethnic Wear", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("11", "Ind Western", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("112", "Sports & Gym Wear", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("122", "TShirt", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("111", "Western Wear", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("123", "Winter & Seasonal", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
        listMenuItem.add(new MenuItems("12333", "Winter & Seasonal", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "L"));
        listMenuItem.add(new MenuItems("71", "Logout", "https://cdn0.iconfinder.com/data/icons/kameleon-free-pack-rounded/110/Settings-5-512.png", "I"));
    }

    @Override
    public void returnedID(String id) {
        Utility.openNavDrawer(id, context);
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public void onClick(View v) {
        if (v == btn_menu) {
            drawer.openDrawer(Gravity.START); //Edit Gravity.START need API 14
        }
    }
}
