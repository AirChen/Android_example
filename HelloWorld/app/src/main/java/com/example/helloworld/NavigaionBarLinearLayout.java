package com.example.helloworld;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NavigaionBarLinearLayout extends LinearLayout implements View.OnClickListener {
    public NavigaionBarLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.navigation_bar_layout, this);

        Button editButton = findViewById(R.id.navigation_edit);
        Button backButton = findViewById(R.id.navigation_back);
        TextView textView = findViewById(R.id.navigation_title);

        textView.setText(textView.getText().toString() + " Version 1.0");

        editButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigation_back:
            {
                ((Activity)getContext()).finish();
            }
            break;
            case R.id.navigation_edit:
            {
                Toast.makeText(getContext(), "Edit model", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}
