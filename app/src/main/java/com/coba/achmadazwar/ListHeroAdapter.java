package com.coba.achmadazwar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ListHeroAdapter extends BaseAdapter {
    private ArrayList<Hero> listHero;
    private Context context;

    public void setHeroes(ArrayList<Hero> listHero){
        this.listHero = listHero;
    }

    public ListHeroAdapter(Context context){

        this.context = context;
        listHero = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return listHero.size();
    }

    @Override
    public Object getItem(int i) {
        return listHero.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_row_hero, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Hero hero = (Hero)getItem(i);
        viewHolder.bind(hero);
        return view;
    }


    private class ViewHolder{
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.tv_item_name);
            txtDescription = view.findViewById(R.id.tv_item_detail);
            imgPhoto = view.findViewById(R.id.img_item_photo);
        }

        void bind(Hero hero){
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDetail());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}