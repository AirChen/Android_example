package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorldActivity extends BasicActivity implements View.OnClickListener {
    private static final String TAG = "HelloWorldActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);

        // 取出被杀死时存储的数据
        if (savedInstanceState != null) {
            String tempString = savedInstanceState.getString("data_save");
            Log.d(TAG, tempString);
        }

        Button toastButton = findViewById(R.id.button_1);
        toastButton.setOnClickListener(this);

        Button intentButton = findViewById(R.id.button_2);
        intentButton.setOnClickListener(this);

        Button tellButton = findViewById(R.id.button_3);
        tellButton.setOnClickListener(this);

        Button netButton = findViewById(R.id.button_4);
        netButton.setOnClickListener(this);

        Button editButton = findViewById(R.id.button_5);
        editButton.setOnClickListener(this);

        Button scrollPButton = findViewById(R.id.button_6);
        scrollPButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(HelloWorldActivity.this,"You Clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(HelloWorldActivity.this,"You Clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:{
                if (resultCode == RESULT_OK) {
                    String dataString = data.getStringExtra("data_result");
                    Log.d("HelloWorldActivity", dataString + getClass().getSimpleName());
                }
            }
                break;

                default:
                    break;
        }
    }

    // 被杀死时保存数据
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("data_save", "This is HelloWorldActivity template data saved!");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
            {
                Toast.makeText(HelloWorldActivity.this, "You Clicked Toast Button", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.button_2:
            {
                SecondActivity.startActivity(HelloWorldActivity.this, "HelloWorldActivity say Hello! ");
            }
            break;
            case R.id.button_3:
            {
                Intent tellIntent = new Intent(Intent.ACTION_VIEW);
                tellIntent.setData(Uri.parse("tel:10086"));

                startActivity(tellIntent);
            }
            break;
            case R.id.button_4:
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));

                startActivityForResult(intent, 1);
            }
            break;
            case R.id.button_5:
            {
                TextEditActivity.startActivity(HelloWorldActivity.this);
            }
            break;
            case R.id.button_6:
            {
                ScrollPartActivity.startActivity(HelloWorldActivity.this);
            }
            break;
        }
    }
}
