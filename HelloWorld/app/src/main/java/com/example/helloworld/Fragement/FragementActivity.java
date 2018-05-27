package com.example.helloworld.Fragement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class FragementActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FragementActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_layout);
        repleaseFragment(new RightFragment());

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repleaseFragment(new AnotherFragement());
            }
        });
    }

    //注意 这里的Fragment需要取自support
    private void repleaseFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.right_framelayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
