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
 * Use the {@link TietKiem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TietKiem extends Fragment {
EditText Tongtien,lai,moithang;
Button Them , tattoan;
    double tongtien;
    Double Lai;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TietKiem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TietKiem.
     */
    // TODO: Rename and change types and number of parameters
    public static TietKiem newInstance(String param1, String param2) {
        TietKiem fragment = new TietKiem();
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
        View view= inflater.inflate(R.layout.fragment_tiet_kiem, container, false);
        lai= view.findViewById(R.id.edtlaitietkiem);
        Tongtien=view.findViewById(R.id.edttientietkiem);
        moithang=view.findViewById(R.id.edttietkiemmoithang);
        Them=view.findViewById(R.id.btntietkiem);
        tongtien=Double.parseDouble(Tongtien.getText().toString());
        NumberFormat formatter1 = new DecimalFormat("#,###");
        double myNumber1 = Double.parseDouble(Tongtien.getText().toString());;
        String formattedNumber1 = formatter1.format(myNumber1);
        Tongtien.setText(formattedNumber1);
        final  double Moithang=Double.parseDouble(moithang.getText().toString());
        double myNumber = Double.parseDouble(moithang.getText().toString());;
        String formattedNumber = formatter1.format(myNumber);
        moithang.setText(formattedNumber);

        final double phantram=0.039;

        lai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lai=tongtien*phantram;
                NumberFormat formatter = new DecimalFormat("#,###");
                double myNumber = Lai;
                String formattedNumber = formatter.format(myNumber);
                lai.setText(formattedNumber);

            }
        });
        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tongtien=tongtien+Moithang+(tongtien*phantram);
                NumberFormat formatter = new DecimalFormat("#,###");
                double myNumber = tongtien;
                String formattedNumber = formatter.format(myNumber);
                Tongtien.setText(formattedNumber);

            }
        });
        return view;
    }
}