package com.example.asm.news_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.asm.R;

public class tintheoloai extends AppCompatActivity {

    String diachi_rss;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintheoloai);

        lv = findViewById(R.id.lvTintheoloai);
        diachi_rss = getIntent().getExtras().getString("diachi_rss");

        MyAsyncTask gandulieu = new MyAsyncTask(getApplicationContext(),diachi_rss,lv);
        gandulieu.execute();
    }
}
