package com.example.asm.news_activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.asm.R;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask <Void,Void,Void> {

    Context c;
    String diachi_rss;
    ArrayList<Item> items;
    ListView lv;

    public MyAsyncTask(Context c, String link, ListView lv){
        this.c =c;
        this.diachi_rss = link;
        this.lv = lv;
        items = new ArrayList();
    }

    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url=new URL(diachi_rss);
            URLConnection connection=url.openConnection();
            InputStream is=connection.getInputStream();
            items= MySaxParser.xmlParser(is);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        try{

            MyAdapter adapter = new MyAdapter(c,R.layout.layout_tintheoloai_itemlistview,items);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String link = items.get(i).getLink();
                    Intent intent = new Intent(c,XemTin.class);
                    intent.putExtra("link",link);
                    c.startActivity(intent);
                }
            });

        }catch(Exception e)
        {
            Log.d("title","adapter khong duoc");
        }
    }
}
