package com.example.quanli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button dangnhap;
    private Button dangki;
    private EditText mapin;
    DatabaseHelper db = new DatabaseHelper(this);
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.commit();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        dangnhap=(Button)findViewById(R.id.btndangnhap);
        dangki=(Button)findViewById(R.id.bttaomapin);
        mapin=findViewById(R.id.edtnhap);

        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,taomapin.class);
                startActivity(i);
            }
        });
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (db.Check(mapin.getText().toString())==true&&!mapin.getText().toString().equals("")){
                    String mp=mapin.getText().toString();
                    id=db.CheckSoDu(mp);
                    Intent i= new Intent(MainActivity.this, trangchu2.class);
                    Bundle bundle1=new Bundle();
                    bundle1.putInt("id",id);
                    i.putExtras(bundle1);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Đăng Nhập Thành Công",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public int getId() {
        return id;
    }
}