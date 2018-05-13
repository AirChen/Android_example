package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScrollPartActivity extends BasicActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ScrollPartActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_part_layout);

        Button listButton = findViewById(R.id.scroll_list);
        Button recyclerButton = findViewById(R.id.scroll_recycle);
        Button chatButton = findViewById(R.id.scroll_chat);

        listButton.setOnClickListener(this);
        recyclerButton.setOnClickListener(this);
        chatButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scroll_list:
            {
                ListViewActivity.startActvity(ScrollPartActivity.this);
            }
            break;
            case R.id.scroll_recycle:
            {
                RecyclerViewActivity.startActivity(ScrollPartActivity.this);
            }
            break;
            case R.id.scroll_chat:
            {
                ChatActivity.startActivity(ScrollPartActivity.this);
            }
            break;
        }
    }
}
