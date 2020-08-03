package com.example.asm.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asm.NonUI;
import com.example.asm.R;
import com.example.asm.adapter.DanhSachKhoaHocAdapter;
import com.example.asm.dao.KhoaHocDAO;
import com.example.asm.dbhelper.DbHelper;
import com.example.asm.model.KhoaHoc;

import java.util.ArrayList;

import static com.example.asm.fragment.KhoaHocCuaToiFragment.listKHCuaToi;

public class DanhSachKhoaHocFragment extends Fragment {

    RecyclerView rv;
    EditText edtFind;
    ImageView imFind;

    public DanhSachKhoaHocFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach_khoa_hoc, container, false);

        rv = view.findViewById(R.id.rcv);
        edtFind = view.findViewById(R.id.edtFind);
        imFind = view.findViewById(R.id.imFind);

        DbHelper dbHelper = new DbHelper(getContext());
        KhoaHocDAO khoaHocDAO = new KhoaHocDAO(dbHelper.getWritableDatabase());

        final ArrayList<KhoaHoc> listKH;
        listKH = (ArrayList<KhoaHoc>) khoaHocDAO.readKhoaHoc();

        imFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ten = edtFind.getText().toString();
                Boolean kq = false;
                String name = "";
                String ngaybd = "";
                String ngaykt = "";
                for (int i = 0; i < listKH.size(); i++) {
                    KhoaHoc a = listKH.get(i);
                    if (ten.equals(a.tenKhoaHoc)) {
                        kq = true;
                        name = a.tenKhoaHoc;
                        ngaybd = a.ngayBatDau;
                        ngaykt = a.ngayKetThuc;
                    }
                }
                if (kq == true) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Bạn có muốn đăng kí không")
                            .setMessage(name + "\n\nTg bắt đầu : " + ngaybd + "\n\nTg kết thúc : " + ngaykt)
                            .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Boolean kq1 = true;
                                    NonUI nonUI = new NonUI(getContext());
                                    for (int j = 0; j < listKHCuaToi.size(); j++) {
                                        if (ten.equalsIgnoreCase(listKHCuaToi.get(j))) {
                                            kq1 = false;
                                        }
                                    }
                                    if (kq1 == true) {
                                        listKHCuaToi.add(ten);
                                        nonUI.toast("Đăng kí thành công");
                                    } else {
                                        nonUI.toast("Khóa học đã được đăng kí");
                                    }
                                }
                            })
                            .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Không có khóa học cần tìm\n")
                            .show();
                }
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        DanhSachKhoaHocAdapter adapter = new DanhSachKhoaHocAdapter(getContext(), listKH);
        rv.setAdapter(adapter);

        return view;
    }

}
