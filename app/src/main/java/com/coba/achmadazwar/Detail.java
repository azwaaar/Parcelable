package com.coba.achmadazwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    Button btn_back;

    ImageView photo;
    TextView judul;
    TextView description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );

        btn_back = findViewById( R.id.btn_back );
        btn_back.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( Detail.this, MainActivity.class );
                startActivity( intent );
            }
        } );

        judul = findViewById( R.id.tv_item_name );
        photo = findViewById( R.id.image1 );
        description = findViewById( R.id.tv_item_detail );

        Hero hero = getIntent().getParcelableExtra( EXTRA_PERSON );
        int image = hero.getPhoto();
        String text = hero.getName();
        String text1 = hero.getDetail();

        photo.setImageResource( image );
        judul.setText( text );
        description.setText( text1 );

    }
}