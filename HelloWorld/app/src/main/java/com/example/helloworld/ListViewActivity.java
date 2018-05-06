package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList;

    public static void startActvity(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        initalFruitList();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item, fruitList);

        final ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit selectedFruit = (Fruit) listView.getItemAtPosition(position);
                Toast.makeText(ListViewActivity.this, selectedFruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initalFruitList() {
        fruitList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Fruit tempFruit1 = new Fruit("Apple", R.drawable.ball);
            fruitList.add(tempFruit1);

            Fruit tempFruit2 = new Fruit("Orange", R.drawable.bear);
            fruitList.add(tempFruit2);
        }
    }
}
