package com.coba.achmadazwar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDetail;
    private String[] tglrelease;
    private TypedArray dataPhoto;
    private ListHeroAdapter adapter;
    private ArrayList<Hero> listHero;
    ImageButton btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_profile = findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoprofile = new Intent(MainActivity.this,MyProfile.class);
                startActivity(gotoprofile);
            }
        });

        adapter = new ListHeroAdapter(this);
        final ListView listView = findViewById(R.id.rv_heroes);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, listHero.get(i).getName(), Toast.LENGTH_SHORT).show();

            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, 1));
            hero.setName( dataName[i] );
            hero.setDetail( dataDetail[i] );
            Intent intent = new Intent(MainActivity.this, Detail.class);
            intent.putExtra(Detail.EXTRA_PERSON, hero);
            startActivity(intent);
        }
    });
}
    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDetail = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDetail(dataDetail[i]);
            listHero.add(hero);
        }
        adapter.setHeroes(listHero);
    }
}