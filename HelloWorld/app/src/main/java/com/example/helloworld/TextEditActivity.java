package com.example.helloworld;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TextEditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private ProgressBar progressBar_normal;
    private ProgressBar progressBar_horizal;
    private TextView textView;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_edit_layout);

        editText = findViewById(R.id.text_edit);

        textView = findViewById(R.id.text_view);
        imgView = findViewById(R.id.text_img);

        progressBar_normal = findViewById(R.id.text_progress_1);
        progressBar_horizal = findViewById(R.id.text_progress_2);

        Button button1 = findViewById(R.id.text_button);
        button1.setOnClickListener(this);
        Button alertButton = findViewById(R.id.text_alert);
        alertButton.setOnClickListener(this);
        Button progressButton = findViewById(R.id.text_progress_dialog);
        progressButton.setOnClickListener(this);
    }

    private void normalProgressChange() {
        if (progressBar_normal.getVisibility() == View.GONE)
            progressBar_normal.setVisibility(View.VISIBLE);
        else
            progressBar_normal.setVisibility(View.GONE);
    }

    private void horizalProgressChange() {
        if (progressBar_horizal.getProgress() == 100)
            progressBar_horizal.setProgress(0);
        else {
            int currentProgress = progressBar_horizal.getProgress();
            progressBar_horizal.setProgress(currentProgress + 10);
        }
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TextEditActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_button:
            {
                String editString = editText.getText().toString();
                Toast.makeText(TextEditActivity.this, editString, Toast.LENGTH_SHORT).show();
                textView.setText(editString);
                imgView.setImageResource(R.drawable.ball);

                normalProgressChange();
                horizalProgressChange();
            }
            break;
            case R.id.text_alert:
            {
                AlertDialog.Builder dialog = new AlertDialog.Builder(TextEditActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
            break;
            case R.id.text_progress_dialog:
            {
                ProgressDialog progressDialog = new ProgressDialog(TextEditActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
            break;
        }
    }
}
