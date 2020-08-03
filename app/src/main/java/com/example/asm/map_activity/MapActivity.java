package com.example.asm.map_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.asm.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btnTim;
    EditText edtDiaChi;
    Marker mym;
    Marker marker_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnTim = findViewById(R.id.btnTim);
        edtDiaChi = findViewById(R.id.edtDiaChi);

        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Geocoder geocoder=new Geocoder(MapActivity.this);
                List<Address> ds_diachi=null;

                ArrayList<Marker> markers = new ArrayList();

                try{
                    ds_diachi=geocoder.getFromLocationName(edtDiaChi.getText().toString(), 30);
                    Toast.makeText(getApplicationContext(), "co:"+ds_diachi.size(), Toast.LENGTH_LONG).show();
                    for(int i=0;i<ds_diachi.size();i++)
                    {
                        Address dc=(Address)ds_diachi.get(i);
                        LatLng vt = new LatLng(dc.getLatitude(),dc.getLongitude());
                        Marker mar = mMap.addMarker(
                                new MarkerOptions()
                                        .position(vt)
                                        .title(dc.getLocality())
                                        .snippet(dc.getFeatureName())
                                        .icon(BitmapDescriptorFactory.defaultMarker(
                                                BitmapDescriptorFactory.HUE_ROSE)));
                        markers.add(mar);//them vao list de de xoa

                        ///di chuyen camera chua toan bo marker
                        LatLngBounds.Builder builder = new LatLngBounds.Builder();
                        for(Marker m : markers) {
                            builder.include(m.getPosition());
                        }
                        LatLngBounds bounds = builder.build();
                        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 5);
                        //map.moveCamera(cu);
                        mMap.animateCamera(cu);
                    }

                } catch (Exception e) {
                // TODO Auto-generated catch block
                Toast.makeText(getApplicationContext(), "loi roi", Toast.LENGTH_LONG).show();
            }
        }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED)
            {
                xuLyQuyen();
                Toast.makeText(this, "e", Toast.LENGTH_SHORT).show();
            } else
            {
                ActivityCompat.requestPermissions(MapActivity.this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION},1);
                Toast.makeText(this, "d", Toast.LENGTH_SHORT).show();
            }
        }else
        {
            xuLyQuyen();
            Toast.makeText(this, "f", Toast.LENGTH_SHORT).show();
        }
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void xuLyQuyen(){
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Toast.makeText(this, "xx", Toast.LENGTH_SHORT).show();
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "xin duoc quyen roi", Toast.LENGTH_SHORT).show();
            xuLyQuyen();
        }
    }

    class veduongdixml extends AsyncTask<Double,Void,Void> {

        ArrayList<LatLng> mangtoado;

        public void veduongdixml(){
            Toast.makeText(MapActivity.this, "nhan nut",Toast.LENGTH_SHORT).show();
            veduongdixml a=new veduongdixml();
            a.execute(mym.getPosition().latitude,
                    mym.getPosition().longitude,
                    marker_b.getPosition().latitude,
                    marker_b.getPosition().longitude);

        }

        @Override
        protected Void doInBackground(Double... params) {
            Direction md = new Direction();
            LatLng x=new LatLng(params[0], params[1]);
            LatLng y=new LatLng(params[2],params[3]);
            Document doc = md.getDocument(x, y, Direction.MODE_DRIVING);
            mangtoado = md.getDirection(doc);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            super.onPostExecute(result);
            PolylineOptions rectLine = new PolylineOptions().width(3).color(Color.RED); // Màu và độ rộng

            for(int i = 0 ; i < mangtoado.size() ; i++) {
                rectLine.add(mangtoado.get(i));
            }
            mMap.addPolyline(rectLine);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateCard(MapActivity.this);
    }

}
