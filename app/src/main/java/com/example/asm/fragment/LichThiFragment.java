package com.example.asm.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asm.R;
import com.example.asm.dao.KhoaHocDAO;
import com.example.asm.dbhelper.DbHelper;
import com.example.asm.model.KhoaHoc;

import java.util.List;

import static com.example.asm.fragment.KhoaHocCuaToiFragment.listKHCuaToi;

public class LichThiFragment extends Fragment {

    TextView tvLichThi1,tvLichThi2,tvLichThi3,tvLichThi4,tvLichThi5,tvLichThi6,tvLichThi7;

    public LichThiFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lich_thi, container, false);

        tvLichThi1 = v.findViewById(R.id.tvLichThi1);
        tvLichThi2 = v.findViewById(R.id.tvLichThi2);
        tvLichThi3 = v.findViewById(R.id.tvLichThi3);
        tvLichThi4 = v.findViewById(R.id.tvLichThi4);
        tvLichThi5 = v.findViewById(R.id.tvLichThi5);
        tvLichThi6 = v.findViewById(R.id.tvLichThi6);
        tvLichThi7 = v.findViewById(R.id.tvLichThi7);

        DbHelper dbHelper = new DbHelper(getContext());
        KhoaHocDAO khoaHocDAO = new KhoaHocDAO(dbHelper.getReadableDatabase());
        List<KhoaHoc> kh = khoaHocDAO.readKhoaHoc();

        switch (listKHCuaToi.size()){
            case 1:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102 \n Ngày"
                        + kh.get(i).ngayKetThuc);
                    }
                }
                break;
            case 2:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102 \n Ngày"
                                + kh.get(i).ngayKetThuc);
                    }
                    if (listKHCuaToi.get(1).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi2.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102  \n Ngày"
                                + kh.get(i).ngayKetThuc);
                    }
                }
                break;
            case 3:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102 \n Ngày"
                                + kh.get(i).ngayKetThuc);
                    }
                    if (listKHCuaToi.get(1).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi2.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102  \n Ngày"
                                + kh.get(i).ngayKetThuc );
                    }
                    if (listKHCuaToi.get(2).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi3.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102  \n Ngày"
                                + kh.get(i).ngayKetThuc);
                    }
                }
                break;
            case 4:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102  \n Ngày"
                                + kh.get(i).ngayKetThuc);
                    }
                    if (listKHCuaToi.get(1).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi2.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102  \n Ngày"
                                + kh.get(i).ngayKetThuc );
                    }
                    if (listKHCuaToi.get(2).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi3.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   \n Ngày"
                                + kh.get(i).ngayKetThuc);
                    }
                    if (listKHCuaToi.get(3).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi4.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102  \n Ngày"
                                + kh.get(i).ngayKetThuc );
                    }
                }
                break;
            case 5:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   \n Ngày"
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(1).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi2.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(2).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi3.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(3).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi4.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(4).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi5.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                }
                break;
            case 6:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(1).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi2.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(2).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi3.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(3).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi4.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(4).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi5.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(5).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi6.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                }
                break;
            case 7:
                for (int i = 0 ; i < kh.size(); i ++){
                    if (listKHCuaToi.get(0).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi1.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(1).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi2.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(2).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi3.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(3).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi4.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(4).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi5.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(5).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi6.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                    if (listKHCuaToi.get(6).equals(kh.get(i).tenKhoaHoc)){
                        tvLichThi7.setText(kh.get(i).tenKhoaHoc + "\n"
                                + "7h30p. Phòng 102   "
                                + kh.get(i).ngayKetThuc + "\n");
                    }
                }
                break;
        }
        return v;
    }
}
