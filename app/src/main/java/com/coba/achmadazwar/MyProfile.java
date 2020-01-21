package com.coba.achmadazwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {

    Button btn_back;
    ImageView img;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btn_back = findViewById(R.id.btn_back);
        img = findViewById(R.id.img2);
        text = findViewById(R.id.text4);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotomain = new Intent(MyProfile.this,MainActivity.class);
                startActivity(gotomain);
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotodetail = new Intent(MyProfile.this,Hello.class);
                startActivity(gotodetail);
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotodetail = new Intent(MyProfile.this,Hello.class);
                startActivity(gotodetail);
            }
        });
    }
}