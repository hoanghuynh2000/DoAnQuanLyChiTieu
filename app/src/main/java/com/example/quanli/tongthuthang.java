package com.example.quanli;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tongthuthang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tongthuthang extends Fragment {
    TextView Thuong, Luong, lai, khac;
    PieChart pieChart;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tongthuthang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tongthuthang.
     */
    // TODO: Rename and change types and number of parameters
    public static tongthuthang newInstance(String param1, String param2) {
        tongthuthang fragment = new tongthuthang();
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
        View view=inflater.inflate(R.layout.fragment_tongthuthang, container, false);
        Luong = view.findViewById(R.id.tvluongthang);
        Thuong = view.findViewById(R.id.tvthuongthang);
        lai = view.findViewById(R.id.tvlaithang);
        khac = view.findViewById(R.id.tvkhacthuthang);
        pieChart = view.findViewById(R.id.piechart);

        Luong.setText(Integer.toString(20000000));
        Thuong.setText(Integer.toString(12000000));
        lai.setText(Integer.toString(3223000));
        khac.setText(Integer.toString(1030000));
        setData();
        return view;
    }
    private void setData()
    {

        // Set dữ liệu vào biểu đồ

        pieChart.addPieSlice(
                new PieModel(
                        "Lương",
                        Integer.parseInt(Luong.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Tiền Thưởng",
                        Integer.parseInt(Thuong.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Tiền lãi",
                        Integer.parseInt(lai.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "Khác",
                        Integer.parseInt(khac.getText().toString()),
                        Color.parseColor("#29B6F6")));


        pieChart.startAnimation();
    }

}