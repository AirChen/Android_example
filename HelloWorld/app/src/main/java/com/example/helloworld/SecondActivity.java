package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends BasicActivity {

    public static void startActivity(Context context, String dataString) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("data", dataString);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent intent = getIntent();
        String dataString = intent.getStringExtra("data");
        Log.i("secondActivity", dataString + getClass().getSimpleName());
    }
}
