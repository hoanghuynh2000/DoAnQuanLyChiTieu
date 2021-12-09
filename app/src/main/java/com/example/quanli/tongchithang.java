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
 * Use the {@link tongchithang#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tongchithang extends Fragment {
    TextView Muasam, Dichvu, Dulich, Nhacua,Khac,Giaothong,Baohiem,Anuong;
    PieChart pieChart;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseHelper db = new DatabaseHelper(getContext());
    public tongchithang() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tongchithang.
     */
    // TODO: Rename and change types and number of parameters
    public static tongchithang newInstance(String param1, String param2) {
        tongchithang fragment = new tongchithang();
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
        View view=inflater.inflate(R.layout.fragment_tongchithang, container, false);

        Anuong = view.findViewById(R.id.tvanuongthang);
        Muasam = view.findViewById(R.id.tvmuasamthang);
        Baohiem = view.findViewById(R.id.tvbaohiemthang);
        Dichvu = view.findViewById(R.id.tvdichvuthang);
        Dulich = view.findViewById(R.id.tvdulichthang);
        Giaothong = view.findViewById(R.id.tvgiaothongthang);
        Khac=view.findViewById(R.id.tvkhacchithang);
        Nhacua=view.findViewById(R.id.tvnhacuathang);
        pieChart = view.findViewById(R.id.piechart);

        Muasam.setText(Integer.toString(1300000));
        Anuong.setText(Integer.toString(4200000));
        Giaothong.setText(Integer.toString(2041000));
        Nhacua.setText(Integer.toString(5420000));
        Baohiem.setText(Integer.toString(2600000));
        Khac.setText(Integer.toString(802000));
        Dulich.setText(Integer.toString(2230000));
        Dichvu.setText(Integer.toString(1200000));
        setData();
        return view;
    }
    private void setData()
    {
        // code block
        pieChart.addPieSlice(
                new PieModel(
                        "Ăn Uống",
                        Integer.parseInt(Anuong.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Giao Thông",
                        Integer.parseInt(Giaothong.getText().toString()),
                        Color.parseColor("#696969")));
        pieChart.addPieSlice(
                new PieModel(
                        "Nhà Cửa",
                        Integer.parseInt(Nhacua.getText().toString()),
                        Color.parseColor("#FFA787")));
        pieChart.addPieSlice(
                new PieModel(
                        "Bảo Hiểm",
                        Integer.parseInt(Baohiem.getText().toString()),
                        Color.parseColor("#9400D3")));
        pieChart.addPieSlice(
                new PieModel(
                        "Khác",
                        Integer.parseInt(Khac.getText().toString()),
                        Color.parseColor("#0000FF")));

        pieChart.addPieSlice(
                new PieModel(
                        "Du Lịch",
                        Integer.parseInt(Dulich.getText().toString()),
                        Color.parseColor("#ffff33")));

        pieChart.addPieSlice(
                new PieModel(
                        "Dịch Vụ",
                        Integer.parseInt(Dichvu.getText().toString()),
                        Color.parseColor("#B22222")));

        // code block
        pieChart.addPieSlice(
                new PieModel(
                        "Mua Sắm",
                        Integer.parseInt(Muasam.getText().toString()),
                        Color.parseColor("#FFC0CB")));


        // To animate the pie chart
        pieChart.startAnimation();
    }
}