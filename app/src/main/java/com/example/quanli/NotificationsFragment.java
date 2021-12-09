package com.example.quanli;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


import com.example.quanli.ui.notifications.NotificationsViewModel;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private TextView ngay, thang , khac;
    private EditText tongthungay,tongchingay,tongthuthang,tongchithang,theongay,theothang;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //khai báo
        ngay=root.findViewById(R.id.btchitietngay);
        thang=root.findViewById(R.id.btchitietthang);
        tongchingay=root.findViewById(R.id.edttongchingay);
        tongthungay=root.findViewById(R.id.edttongthungay);
        tongchithang=root.findViewById(R.id.edttongchithang);
        tongthuthang=root.findViewById(R.id.edttongthuthang);
        theongay=root.findViewById(R.id.edttheongay);
        theothang=root.findViewById(R.id.edttheothang);
        khac=root.findViewById(R.id.tvkhacthungay);
//set ngày
        DateFormat time = new SimpleDateFormat("dd");
        String thoigian = time.format(Calendar.getInstance().getTime());
        DateFormat df = new SimpleDateFormat("MM");
        String date = df.format(Calendar.getInstance().getTime());
        // lấy thu chi
        trangchu2 tc=(trangchu2)getActivity();
        DatabaseHelper db = new DatabaseHelper(getContext());
        DoiTuong dt= db.getDoiTuong(tc.getId());
        String thu=tc.getThungay();
        String chi = tc.getChingay();
//set kiểu hiển thị số tiền
            NumberFormat formatterthu = new DecimalFormat("#,###");
            double myNumberthu = Double.parseDouble(String.valueOf(thu));
            String formattedNumberthu = formatterthu.format(myNumberthu);
            dt.setThungay(String.valueOf(thu));
            db.udThungay(dt);
            tongthungay.setText(formattedNumberthu);
            tongthuthang.setText(formattedNumberthu);

            NumberFormat formatter = new DecimalFormat("#,###");
            double myNumber = Double.parseDouble(String.valueOf(chi));
            String formattedNumber = formatter.format(myNumber);
            dt.setChingay(String.valueOf(chi));
            db.udChingay(dt);
            tongchingay.setText(formattedNumber);
            tongchithang.setText(formattedNumber);


        khac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(root.getContext(),ThongKeKhac.class);
                startActivity(i);
            }
        });
        ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(root.getContext(),theongay.class);
                startActivity(i);
            }
        });
        thang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(root.getContext(), theothang.class);
                startActivity(i);
            }
        });
        theongay.setText(thoigian);
        theothang.setText(date);
        return root;
    }



}