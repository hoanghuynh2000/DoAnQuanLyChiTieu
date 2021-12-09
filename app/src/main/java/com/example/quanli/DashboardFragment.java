package com.example.quanli;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.quanli.R;
import com.example.quanli.ui.dashboard.DashboardViewModel;

public class DashboardFragment extends Fragment {
    ListView listView;
    DatabaseHelper conn ;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        listView=root.findViewById(R.id.lvThu);
        conn = new DatabaseHelper(getContext());
        //Biến Con trỏ để get Bảng
        Cursor cursor =conn.getAllThuchi();
        String []from = {"THOIGIAN","SOTIEN","PHANLOAI","KHOANTHUCHI","GHICHU"};
        int []to = {R.id.tvThoigian2,R.id.tvSotien2,R.id.tvPhanloai2,R.id.tvthuchi2,R.id.tvGhichu2};
        //Cho Show lên Layout đã tạo trước
        SimpleCursorAdapter adapter= new SimpleCursorAdapter(getContext(),R.layout.student_item,cursor,from,to,0);
        listView.setAdapter(adapter);
        return root;
    }
}