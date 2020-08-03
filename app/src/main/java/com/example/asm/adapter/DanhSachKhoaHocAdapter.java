package com.example.asm.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.NonUI;
import com.example.asm.R;
import com.example.asm.model.KhoaHoc;

import java.util.ArrayList;

import static com.example.asm.fragment.KhoaHocCuaToiFragment.listKHCuaToi;

public class DanhSachKhoaHocAdapter extends RecyclerView.Adapter<DanhSachKhoaHocAdapter.ViewHolder> {

    Context context;
    public ArrayList<KhoaHoc> ds;

    public DanhSachKhoaHocAdapter(Context context, ArrayList<KhoaHoc> ds) {
        this.context = context;
        this.ds = ds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_ds_khoa_hoc, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvTenKhoaHoc.setText(ds.get(position).tenKhoaHoc);
        holder.tvTgBatDau.setText("Bắt đầu : " + ds.get(position).ngayBatDau);
        holder.tvTgKetThuc.setText("Kết thúc : " + ds.get(position).ngayKetThuc);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn có muốn đăng kí khóa học này không ?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                NonUI nonUI = new NonUI(context);
                                Boolean kq2 = true;
                                for(int j = 0 ; j < listKHCuaToi.size(); j++){
                                    if(holder.tvTenKhoaHoc.getText().toString().equalsIgnoreCase(listKHCuaToi.get(j))){
                                        kq2 = false;
                                    }
                                }

                                if(kq2 == true){
                                    listKHCuaToi.add(holder.tvTenKhoaHoc.getText().toString());
                                    nonUI.toast("Đăng kí thành công");
                                }else{
                                    nonUI.toast("Khóa học đã được đăng kí");
                                }

                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTenKhoaHoc;
        public TextView tvTgKetThuc;
        public TextView tvTgBatDau;

        public ViewHolder(View view) {
            super(view);
            tvTenKhoaHoc = view.findViewById(R.id.tvTenKhoaHoc);
            tvTgBatDau = view.findViewById(R.id.tvTGBatDau);
            tvTgKetThuc = view.findViewById(R.id.tvTGKetThuc);
        }
    }
}
