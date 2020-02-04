package com.customdrawer.app;

import android.content.Context;
import android.content.Intent;

public class Utility {

    public static void openNavDrawer(String id, final Context context) {
        if (id.equalsIgnoreCase("1")) {
            Intent i = new Intent(context, ActivityDemo.class);
            context.startActivity(i);
        } else if (id.equalsIgnoreCase("2")) {
            Intent i = new Intent(context, ActivityDemo1.class);
            context.startActivity(i);
        }
    }
}
