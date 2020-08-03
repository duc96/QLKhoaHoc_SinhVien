package com.example.asm.news_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.asm.R;

public class NewsActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        lv = findViewById(R.id.lv);

        String[] ten_loai = {"Thế Giới", "Du lịch", "Kinh doanh", "Thể thao","Pháp luật","Giải trí"};
        final String[] rss_loai = {"https://beta.vnexpress.net/rss/the-gioi.rss",
                "https://beta.vnexpress.net/rss/du-lich.rss",
                "https://beta.vnexpress.net/rss/kinh-doanh.rss",
                "https://beta.vnexpress.net/rss/the-thao.rss",
                "https://beta.vnexpress.net/rss/phap-luat.rss",
                "https://beta.vnexpress.net/rss/giai-tri.rss"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ten_loai);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                Intent intent = new Intent(NewsActivity.this,tintheoloai.class);
                intent.putExtra("diachi_rss", rss_loai[arg2]);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSwipeRight(NewsActivity.this);
    }
}
