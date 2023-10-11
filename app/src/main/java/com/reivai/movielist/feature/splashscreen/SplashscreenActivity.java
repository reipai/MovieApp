package com.reivai.movielist.feature.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.reivai.movielist.databinding.ActivitySplashscreenBinding;
import com.reivai.movielist.feature.movielist.MainActivity;
import com.reivai.movielist.session.Session;
import com.reivai.movielist.utils.GlobalFunction;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SplashscreenActivity extends AppCompatActivity {

    private ActivitySplashscreenBinding binding;
    private GlobalFunction globalFunction;
    private SweetAlertDialog alertDialog;
    private String connectionMode;
    private Context context;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        context = this;
        session = new Session(context);
        globalFunction = new GlobalFunction(context);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        globalFunction.setWindow(this, WindowManager.LayoutParams.FLAG_FULLSCREEN, false);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        new Handler().postDelayed(() ->{
            if (globalFunction.isNetworkAvailable()) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra(connectionMode, "online");
                startActivity(intent);
                finish();
            } else {
                if (session.getMovie() != null) {
                    alertDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
                    alertDialog.setContentText("Anda sedang masuk dalam mode offline, nyalakan koneksi anda agar bisa melihat film terbaru")
                            .setConfirmClickListener(sweetAlertDialog -> {
                                Intent intent = new Intent(this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra(connectionMode, "offline");
                                startActivity(intent);
                                finish();
                            })
                            .setConfirmText("Ok")
                            .show();
                } else {
                    alertDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
                    alertDialog.setContentText("Maaf saat ini data Movie anda masih kosong, mohon untuk menyalakan internet terlebih dahulu")
                            .setConfirmClickListener(sweetAlertDialog -> {
                                finish();
                                System.exit(0);
                            })
                            .setTitleText("Warning")
                            .show();
                }

            }
        }, 2000);

    }


}