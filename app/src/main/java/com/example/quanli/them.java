package com.example.quanli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

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


public class them extends AppCompatActivity {
EditText tgian;
EditText GhiChu , Sotien ;
Button luu;
Spinner PhanLoai;
DatabaseHelper db = new DatabaseHelper(this);
int kq;
public static String Nhan;
String chuyenchi;

int kqchi;
DoiTuong doiTuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.commit();
        tgian=(EditText)findViewById(R.id.edthoigian);
        GhiChu=(EditText)findViewById(R.id.edGhiChu);
        Sotien=(EditText)findViewById(R.id.edSotien);
        Nhan =Sotien.getText().toString();
        luu= (Button)findViewById(R.id.btthem);
        PhanLoai=findViewById(R.id.spinner1);
        db= new DatabaseHelper(this);
        DateFormat time = new SimpleDateFormat("HH:mm , dd MM yyyy");
        final String thoigian = time.format(Calendar.getInstance().getTime());
        DateFormat fthang = new SimpleDateFormat("MM");
        final String thang = fthang.format(Calendar.getInstance().getTime());
        DateFormat fngay = new SimpleDateFormat("MM");
        final String ngay = fngay.format(Calendar.getInstance().getTime());
        tgian.setText(thoigian);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Bundle goi=getIntent().getExtras();
        final int id= goi.getInt("id");

        final DoiTuong dt= db.getDoiTuong(id);
        dt.setIddangki(id);
        final String lay= dt.getSodu();
        final String laychi=dt.getChingay();
        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String thgian=tgian.getText().toString();
                String stien=Sotien.getText().toString();
                String Phanloai=PhanLoai.getSelectedItem().toString();
                String ghichu= GhiChu.getText().toString();
                if(!stien.equals("")&&!ghichu.equals("")){
                db.AddThuChi(thgian,thang,ngay,stien,Phanloai,"Kho???n Chi",ghichu);
                //l???y data trong EditText v?? nh???n data trong b???ng sqlite
                int tien = Integer.parseInt(lay);
                int tinh = Integer.parseInt(stien);
                kq= tien-tinh;
                //set s??? d?? v??o Textview v?? c???p nh???t l???i b???ng ????ng K?? SQLite
                dt.setSodu(String.valueOf(kq));
                db.UdSoDu(dt);
                int tienchi =Integer.parseInt(laychi);
                kqchi=tienchi+tinh;
                if (tienchi>=1000000)
                {
                    Toast.makeText(getApplicationContext(),"H??m nay ???? s??? d???ng tr??n 1,000,000",Toast.LENGTH_LONG).show();
                }
                dt.setChingay(String.valueOf(kqchi));
                db.udChingay(dt);
                //?????y D??? Li???u t??? Th??m Chi qua Trang Ch??? ????? hi???n th???
                 Intent i= new Intent(them.this,trangchu2.class);
                 Bundle b= new Bundle();
                 b.getInt("kqchi",kqchi);
                 b.putString("sotien",stien);
                 b.putInt("id",dt.getIddangki());
                 i.putExtras(b);
                chuyenchi=Sotien.getText().toString();
                Toast.makeText(getApplicationContext(),
                        "Th??m Th??nh C??ng !!", Toast.LENGTH_LONG).show();
                startActivity(i);}
                else {
                    Toast.makeText(getApplicationContext(),"Thi???u Th??ng Tin",Toast.LENGTH_LONG).show();
                }

            }
        });
        return;
    }

}