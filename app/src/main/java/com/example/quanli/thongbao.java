package com.example.quanli;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link thongbao#newInstance} factory method to
 * create an instance of this fragment.
 */
public class thongbao extends Fragment {

    public String[] danhSach ={"-Quản lý chi tiêu để định hướng tương lai thật tốt nhé .","-Làm ra tiền đã khó, nhưng chi tiêu tiền càng khó hơn.","-Không quan trọng là bạn có bao nhiêu tiền trong túi mà điều quan trọng là bạn giữ lại được bao nhiêu tiền và làm cho số tiền đó sinh sôi nảy nở nhiều hơn."};
    private ListView lvDanhSach;
    private ArrayAdapter<String> mainAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public thongbao() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thongbao.
     */
    // TODO: Rename and change types and number of parameters
    public static thongbao newInstance(String param1, String param2) {
        thongbao fragment = new thongbao();
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
        View view =inflater.inflate(R.layout.fragment_thongbao, container, false);
        lvDanhSach = view.findViewById(R.id.lvThongBao);
        mainAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,danhSach);
        lvDanhSach.setAdapter(mainAdapter);
        return view;
    }
}