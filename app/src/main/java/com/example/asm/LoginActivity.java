package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.asm.map_activity.MapActivity;
import com.example.asm.news_activity.NewsActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtTenDangNhap;
    EditText edtMatKhau;
    Button btnDangNhap;
    Button btnDangKi;
    ImageView imMap;
    ImageView imNews;
    ImageView imFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        map();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtTenDangNhap.getText().toString();
                String pass = edtMatKhau.getText().toString();

                if(name.equals("admin") && pass.equals("admin")){
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công. ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);

                    Notification noti = new Notification.Builder(LoginActivity.this)
                            .setContentTitle("Dang nhap thanh cong !")
                            .setContentText("Xin chao Admin").setSmallIcon(R.drawable.ic_launcher_foreground)
                            .build();

                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                    noti.flags = Notification.FLAG_AUTO_CANCEL;

                    notificationManager.notify(0, noti);

                    startActivity(intent);

                    Animatoo.animateFade(LoginActivity.this);
                }else{
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MapActivity.class);
                startActivity(intent);
                Animatoo.animateInAndOut(LoginActivity.this);
            }
        });

        imNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                startActivity(intent);
                Animatoo.animateWindmill(LoginActivity.this);
            }
        });

        imFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,FaceActivity.class);
                startActivity(intent);
                Animatoo.animateShrink(LoginActivity.this);
            }
        });
    }

    private void map(){
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        btnDangNhap = findViewById(R.id.btnDangNhap);
//        btnDangKi = findViewById(R.id.btnDangKi);
        imMap = findViewById(R.id.imMap);
        imNews = findViewById(R.id.imNews);
        imFace = findViewById(R.id.imFace);
    }
}
