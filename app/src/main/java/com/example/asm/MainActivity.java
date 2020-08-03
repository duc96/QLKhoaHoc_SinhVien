package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.asm.dao.HocKiDAO;
import com.example.asm.dao.KhoaHocDAO;
import com.example.asm.dbhelper.DbHelper;
import com.example.asm.model.HocKi;
import com.example.asm.model.KhoaHoc;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvHK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map();
        DbHelper dbHelper = new DbHelper(this);
        HocKiDAO hocKiDAO = new HocKiDAO(dbHelper.getWritableDatabase());

        List tenHocKi = hocKiDAO.readTenHocKi();

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tenHocKi);

        lvHK.setAdapter(adapter);

        lvHK.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,KhoaHocActivity.class);
                startActivity(intent);
                Animatoo.animateSlideRight(MainActivity.this);
            }
        });
    }

    protected void map(){
        lvHK = findViewById(R.id.lvHK);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSwipeRight(MainActivity.this);
    }
}
