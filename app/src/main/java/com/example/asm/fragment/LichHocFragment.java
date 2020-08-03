package com.example.asm.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asm.R;

import static com.example.asm.fragment.KhoaHocCuaToiFragment.listKHCuaToi;

public class LichHocFragment extends Fragment {

    TextView t2c1, t2c2, t2c3, t2c4, t2c5;
    TextView t3c1, t3c2, t3c3, t3c4, t3c5;
    TextView t4c1, t4c2, t4c3, t4c4, t4c5;
    TextView t5c1, t5c2, t5c3, t5c4, t5c5;
    TextView t6c1, t6c2, t6c3, t6c4, t6c5;
    TextView t7c1, t7c2, t7c3;

    public LichHocFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lich_hoc, container, false);

        t2c1 = v.findViewById(R.id.t2c1);
        t2c2 = v.findViewById(R.id.t2c2);
        t2c3 = v.findViewById(R.id.t2c3);
        t3c1 = v.findViewById(R.id.t3c1);
        t3c2 = v.findViewById(R.id.t3c2);
        t3c3 = v.findViewById(R.id.t3c3);
        t4c1 = v.findViewById(R.id.t4c1);
        t4c2 = v.findViewById(R.id.t4c2);
        t4c3 = v.findViewById(R.id.t4c3);
        t5c1 = v.findViewById(R.id.t5c1);
        t5c2 = v.findViewById(R.id.t5c2);
        t5c3 = v.findViewById(R.id.t5c3);
        t6c1 = v.findViewById(R.id.t6c1);
        t6c2 = v.findViewById(R.id.t6c2);
        t6c3 = v.findViewById(R.id.t6c3);
        t7c1 = v.findViewById(R.id.t7c1);
        t7c2 = v.findViewById(R.id.t7c2);
        t7c3 = v.findViewById(R.id.t7c3);

        switch (listKHCuaToi.size()) {
            case 1:
                t2c1.setText(listKHCuaToi.get(0));
                break;
            case 2:
                t2c1.setText(listKHCuaToi.get(0));
                t3c1.setText(listKHCuaToi.get(1));
                break;
            case 3:
                t2c1.setText(listKHCuaToi.get(0));
                t3c1.setText(listKHCuaToi.get(1));
                t4c2.setText(listKHCuaToi.get(2));
                break;
            case 4:
                t2c1.setText(listKHCuaToi.get(0));
                t3c1.setText(listKHCuaToi.get(1));
                t4c2.setText(listKHCuaToi.get(2));
                t5c1.setText(listKHCuaToi.get(3));
                break;
            case 5:
                t2c1.setText(listKHCuaToi.get(0));
                t3c1.setText(listKHCuaToi.get(1));
                t4c2.setText(listKHCuaToi.get(2));
                t5c1.setText(listKHCuaToi.get(3));
                t6c3.setText(listKHCuaToi.get(4));
                break;
            case 6:
                t2c1.setText(listKHCuaToi.get(0));
                t3c1.setText(listKHCuaToi.get(1));
                t4c2.setText(listKHCuaToi.get(2));
                t5c1.setText(listKHCuaToi.get(3));
                t6c3.setText(listKHCuaToi.get(4));
                t2c2.setText(listKHCuaToi.get(5));
                break;
            case 7:
                t2c1.setText(listKHCuaToi.get(0));
                t3c1.setText(listKHCuaToi.get(1));
                t4c2.setText(listKHCuaToi.get(2));
                t5c1.setText(listKHCuaToi.get(3));
                t6c3.setText(listKHCuaToi.get(4));
                t3c3.setText(listKHCuaToi.get(5));
                t2c2.setText(listKHCuaToi.get(6));
                break;
        }
        return v;
    }
}
