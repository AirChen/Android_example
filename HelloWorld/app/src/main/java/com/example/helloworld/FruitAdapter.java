package com.example.helloworld;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);

        View view;
        FruitCache fruitCache;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            fruitCache = new FruitCache();
            fruitCache.iconView = view.findViewById(R.id.fruit_image);
            fruitCache.nameText = view.findViewById(R.id.fruit_name);
            view.setTag(fruitCache);
        } else {
            view = convertView;
            fruitCache = (FruitCache) view.getTag();
        }

        fruitCache.iconView.setImageResource(fruit.getImageId());
        fruitCache.nameText.setText(fruit.getName());

        return view;
    }

    private class FruitCache {
        ImageView iconView;
        TextView nameText;
    }
}
