package com.example.quanli;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoanVay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoanVay extends Fragment {
EditText Tongvay, Lai, Tragoc,Tongtien,Sothang;
Button Tinh,ThanhToan;
double tongvay, lai, tragoc,tongtien,sothang;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KhoanVay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KhoanVay.
     */
    // TODO: Rename and change types and number of parameters
    public static KhoanVay newInstance(String param1, String param2) {
        KhoanVay fragment = new KhoanVay();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_khoan_vay, container, false);
       Tongvay= view.findViewById(R.id.edtKhoanvay);
       Lai=view.findViewById(R.id.edtlaivay);
       Tragoc=view.findViewById(R.id.tragoc);
       Tongtien=view.findViewById(R.id.edttongtientravay);
       Sothang=view.findViewById(R.id.edtsothang);
       Tinh= view.findViewById(R.id.btntinh);
       ThanhToan=view.findViewById(R.id.btnthanhtoan);
       //Lấy Dữ Liệu
       tongvay=Double.parseDouble(Tongvay.getText().toString());
        NumberFormat formatter = new DecimalFormat("#,###");
        double myNumber = Double.parseDouble(Tongvay.getText().toString());
        String formattedNumber = formatter.format(myNumber);
        Tongvay.setText(formattedNumber);
       lai=Double.parseDouble(Lai.getText().toString());
       tragoc=Double.parseDouble(Tragoc.getText().toString());
       tongtien=Double.parseDouble(Tongtien.getText().toString());

        double myNumber1 = Double.parseDouble(Tragoc.getText().toString());
        String formattedNumber1 = formatter.format(myNumber1);
        Tragoc.setText(formattedNumber1);
       sothang=Double.parseDouble(Sothang.getText().toString());
       //Xử Lý Tính Toán và đưa về textview
        Tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lai=tongvay*0.002;
                tragoc=Double.parseDouble(Tragoc.getText().toString());
                tongtien=tragoc+lai;
                NumberFormat formatter = new DecimalFormat("#,###");
                double myNumber = tongtien;
                String formattedNumber = formatter.format(myNumber);
                Tongtien.setText(formattedNumber);
                double myNumber1 = lai;
                String formattedNumber1 = formatter.format(myNumber1);
                Lai.setText(formattedNumber1);
            }
        });
        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tongvay=tongvay-tragoc;
                NumberFormat formatter = new DecimalFormat("#,###");
                double myNumber = tongvay;
                String formattedNumber = formatter.format(myNumber);
                Tongvay.setText(formattedNumber);
                sothang=sothang-1;
                Sothang.setText(String.valueOf(sothang));
            }
        });
       return view;
    }
}