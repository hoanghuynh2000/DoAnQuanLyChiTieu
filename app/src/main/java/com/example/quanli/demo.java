package com.example.quanli;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class demo extends AppCompatActivity {
    ListView listView;
    DatabaseHelper conn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        listView=findViewById(R.id.lvdemo);
        conn = new DatabaseHelper(this);
        Cursor cursor =conn.getAllThuchi();
        String []from = {"THOIGIAN","SOTIEN","PHANLOAI","KHOANTHUCHI","GHICHU"};
        int []to = {R.id.tvThoigian2,R.id.tvSotien2,R.id.tvPhanloai2,R.id.tvthuchi2,R.id.tvGhichu2};
        SimpleCursorAdapter adapter= new SimpleCursorAdapter(this,R.layout.student_item,cursor,from,to,0);
        listView.setAdapter(adapter);
    }
}