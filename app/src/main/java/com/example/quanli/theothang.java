package com.example.quanli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class theothang extends AppCompatActivity {
Button quaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theothang);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        quaylai=findViewById(R.id.btquaylaithang);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        BottomNavigationView navView = findViewById(R.id.btnavtabthang);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder( R.id.nav_tongchithang, R.id.nav_tongthuthang).build();
        NavController navController = Navigation.findNavController(this, R.id.fragmenttheothang);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}