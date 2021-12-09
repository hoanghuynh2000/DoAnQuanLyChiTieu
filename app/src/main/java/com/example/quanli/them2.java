package com.example.quanli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class them2 extends AppCompatActivity {
    EditText tgian;
    EditText GhiChu , Sotien ;
    Button luu;
    Spinner PhanLoai;
    DatabaseHelper db;
    int kq,kqnhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them2);
        tgian=(EditText)findViewById(R.id.edthoigian);
        GhiChu=(EditText)findViewById(R.id.edGhiChu);
        Sotien=(EditText)findViewById(R.id.edSotien);

        luu= (Button)findViewById(R.id.btthem);
        PhanLoai=findViewById(R.id.spinner1);
        db= new DatabaseHelper(this);
        DateFormat time = new SimpleDateFormat("HH:mm , dd MM yy");
        final String thoigian = time.format(Calendar.getInstance().getTime());
        DateFormat fthang = new SimpleDateFormat("MM");
        final String thang = fthang.format(Calendar.getInstance().getTime());
        DateFormat fngay = new SimpleDateFormat("MM");
        final String ngay = fngay.format(Calendar.getInstance().getTime());
        tgian.setText(thoigian);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Thu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Bundle goi=getIntent().getExtras();
        final int id= goi.getInt("id");

        final DoiTuong dt= db.getDoiTuong(id);
        dt.setIddangki(id);
        final String lay= dt.getSodu();
        final String laythu=dt.getThungay();
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String thgian=tgian.getText().toString();
                String stien=Sotien.getText().toString();
                String Phanloai=PhanLoai.getSelectedItem().toString();
                String ghichu= GhiChu.getText().toString();
                if(!stien.equals("")&&!ghichu.equals("")){
                db.AddThuChi(thgian,thang,ngay,stien,Phanloai,"Khoản Thu",ghichu);

                int tien = Integer.parseInt(lay);
                int tinh = Integer.parseInt(stien);
                kq= tien+tinh;
                //set dữ liệu vào textview và cập nhật trong bảng Đăng Kí
                dt.setSodu(String.valueOf(kq));
                db.UdSoDu(dt);
                int tienchi =Integer.parseInt(laythu);
                kqnhan=tienchi+tinh;
                dt.setThungay(String.valueOf(kqnhan));
                db.udThungay(dt);
                //Truyền dữ liệu đi qua trang chủ
                Intent i= new Intent(them2.this,trangchu2.class);
                Bundle b= new Bundle();
                b.putString("sotienthu",stien);
                b.putInt("kqthu",kqnhan);
                b.putInt("id",dt.getIddangki());
                i.putExtras(b);
                Toast.makeText(getApplicationContext(),
                        "Thêm Thành Công !!", Toast.LENGTH_LONG).show();
                startActivity(i);} else {
                    Toast.makeText(getApplicationContext(),"Thiếu Thông Tin",Toast.LENGTH_LONG).show();
                }
            }
        });
        return;
    }
}