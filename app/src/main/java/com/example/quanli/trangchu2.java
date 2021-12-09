package com.example.quanli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class trangchu2 extends AppCompatActivity {
    TextView sodu;
    Button treo;
    Button treo1;
    String Sodu;
    private static String tiengui;
    String tienthu;
    private int id;
    String chingay,thungay;
    String thuchi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu2);

       sodu= findViewById(R.id.etSoDu);
        Sodu=sodu.getText().toString();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_thongbao)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.navkhoanchi);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Bundle goi=getIntent().getExtras();
        id= goi.getInt("id");
        tiengui=goi.getString("sotien");
        tienthu=goi.getString("sotienthu");
        final DatabaseHelper db=new DatabaseHelper(this);
        DoiTuong dt= db.getDoiTuong(id);
        String lay= dt.getSodu();
        chingay=String.valueOf(dt.getChingay());
        thungay=String.valueOf(dt.getThungay());

        NumberFormat formatter = new DecimalFormat("#,###");
        double myNumber = Double.parseDouble(lay);
        String formattedNumber = formatter.format(myNumber);
        sodu.setText(formattedNumber);

        treo=(Button)findViewById(R.id.bttreo);
        treo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(trangchu2.this,them.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id", id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        treo1=(Button)findViewById(R.id.bttreo2);
        treo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(trangchu2.this,them2.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


    }

    public int getId() {
        return id;
    }

    public String getChingay() {
        return chingay;
    }

    public String getThungay() {
        return thungay;
    }
}