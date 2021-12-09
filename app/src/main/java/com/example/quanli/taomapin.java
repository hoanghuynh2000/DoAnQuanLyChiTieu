package com.example.quanli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class taomapin extends AppCompatActivity {


EditText hoten,sodienthoai,mapin, nhaplaimapin;
Button dangki;
DoiTuong dt;
int sodu=0;
int thungay=0;
int chingay=0;

    private int mode;
    private static final int MODE_CREATE = 1;
    private static final int MODE_EDIT = 2;
    private boolean needRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taomapin);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        hoten= (EditText)findViewById(R.id.edthoten);
        sodienthoai=(EditText)findViewById(R.id.edtsodienthoai);
        mapin=(EditText)findViewById(R.id.edtmapin);
        nhaplaimapin=(EditText)findViewById(R.id.edtnhaplaimapin);
        dangki=(Button)findViewById(R.id.btdongy);

        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Save();
            }
        });
    Intent intent = this.getIntent();
        this.dt = (DoiTuong) intent.getSerializableExtra("khachHang");
        if(dt== null)  {
        this.mode = MODE_CREATE;
    } else  {
        this.mode = MODE_EDIT;
        this.hoten.setText(dt.getHoten());
        this.sodienthoai.setText(dt.getSodienthoai());
        this.mapin.setText(dt.getMapin());
        this.nhaplaimapin.setText(dt.getNhaplaimapin());

    }}
    public void Save()
    {

        DatabaseHelper db = new DatabaseHelper(this);
        int maKH=1000+db.getKHCount();
        String ten = this.hoten.getText().toString();
        String sdt = this.sodienthoai.getText().toString();
        String MP=this.mapin.getText().toString();
        String NLMP=this.nhaplaimapin.getText().toString();
        if(MP.equals(NLMP)&&!ten.equals("")&&!sdt.equals("")&&!MP.equals(""))
        {

            if (mode == MODE_CREATE) {
                DoiTuong doiTuong = new DoiTuong(maKH, ten, sdt, MP, NLMP,String.valueOf(sodu),
                        String.valueOf(chingay),String.valueOf(thungay) );
                db.AddDangKi(doiTuong);
                Toast.makeText(getApplicationContext(),
                        "Đăng Kí Thành Công !!", Toast.LENGTH_LONG).show();
            } else {

                this.dt.setIddangki(maKH);
                this.dt.setHoten(ten);
                this.dt.setSodienthoai(sdt);
                this.dt.setMapin(MP);
                this.dt.setNhaplaimapin(NLMP);
                this.dt.setSodu(String.valueOf(sodu));
                this.dt.setChingay(String.valueOf(chingay));
                this.dt.setThungay(String.valueOf(thungay));
                db.UpdateKH(dt);
            }
            this.needRefresh=true;
            this.onBackPressed();
            return;
        }
        else {Toast.makeText(getApplicationContext(),"Đăng kí Thất bại !! ",Toast.LENGTH_LONG).show();}

        }
    @Override
    public void finish() {

        // Create Intent
        Intent data = new Intent();

        // Request MainActivity refresh its ListView (or not).
        data.putExtra("needRefresh", needRefresh);

        // Set Result
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
    }

