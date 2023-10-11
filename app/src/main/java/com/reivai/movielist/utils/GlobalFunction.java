package com.reivai.movielist.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Window;
import android.view.WindowManager;

public class GlobalFunction {
    Context context;

    public GlobalFunction(Context context) {
        this.context = context;
    }

    public void setWindow(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParam = win.getAttributes();
        if (on) {
            winParam.flags |= bits;
        } else{
            winParam.flags &= ~bits;
        }
        win.setAttributes(winParam);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
