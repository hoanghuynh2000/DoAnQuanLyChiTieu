package com.example.quanli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class theongay extends AppCompatActivity {

Button quaylai;
    EditText ngay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theongay);
        quaylai=findViewById(R.id.btquaylaingay);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ngay=findViewById(R.id.edtngay);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        DateFormat time = new SimpleDateFormat("dd MM yyyy");
        String thoigian = time.format(Calendar.getInstance().getTime());
        ngay.setText(thoigian);
        BottomNavigationView navView = findViewById(R.id.btnavtheongay);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder( R.id.nav_tongchingay, R.id.nav_tongthungay).build();
        NavController navController = Navigation.findNavController(this, R.id.fragmenttheongay);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }




}
