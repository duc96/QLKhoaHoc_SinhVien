package com.example.asm.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asm.R;
import com.example.asm.model.KhoaHoc;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static com.example.asm.KhoaHocActivity.toolbar;

public class KhoaHocCuaToiFragment extends Fragment {

    BottomNavigationView botNavi;
    public static ArrayList<String> listKHCuaToi = new ArrayList<>();
    ListView lvMyKhoaHoc;

    public KhoaHocCuaToiFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khoa_hoc_cua_toi, container, false);

        botNavi = view.findViewById(R.id.botNavi);
        lvMyKhoaHoc = view.findViewById(R.id.lvKhoaHocCuaToi);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1, listKHCuaToi);

        lvMyKhoaHoc.setAdapter(adapter);

        botNavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.lich_hoc:
                        toolbar.setTitle("Lịch học");
                        LichHocFragment f0 = new LichHocFragment();
                        getFragmentManager().beginTransaction()
                                .replace(R.id.framKhoaHocCuaToi, f0)
                                .commit();
                        break;
                    case R.id.lich_thi:
                        toolbar.setTitle("Lịch thi");
                        LichThiFragment f1 = new LichThiFragment();
                        getFragmentManager().beginTransaction()
                                .replace(R.id.framKhoaHocCuaToi, f1)
                                .commit();
                        break;
                }
                return false;
            }
        });


        return view;
    }

}
