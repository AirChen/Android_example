package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RecyclerFruitAdapter extends RecyclerView.Adapter<RecyclerFruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitImage = view.findViewById(R.id.fruit_image);
            fruitName = view.findViewById(R.id.fruit_name);
        }
    }

    public RecyclerFruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        holder.fruitImage.setImageResource(fruit.getImageId());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycle);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerFruitAdapter adapter = new RecyclerFruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        fruitList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Fruit tempFruit1 = new Fruit(getRandomLengthName("Apple"), R.drawable.ball);
            fruitList.add(tempFruit1);

            Fruit tempFruit2 = new Fruit(getRandomLengthName("Orange"), R.drawable.bear);
            fruitList.add(tempFruit2);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i < length;i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
