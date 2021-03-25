package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String LOG_TAG = "MainActivity";

    Button dugme1;
    Button dugme2;
    Button dugme3;
    Button dugme4;
    Button dugme5;
    Button dugme6;

    EditText editText;
    TextView textView;
    static int cntDugme2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "Created");

        dugme1 = findViewById(R.id.dugme1);
        dugme1.setOnClickListener(this);

        dugme2 = findViewById(R.id.dugme2);
        dugme2.setOnClickListener(this);

        dugme3 = findViewById(R.id.dugme3);
        dugme3.setOnClickListener(this);

        dugme4 = findViewById(R.id.dugme4);
        dugme4.setOnClickListener(this);

        dugme5 = findViewById(R.id.dugme5);
        dugme5.setOnClickListener(this);

        dugme6 = findViewById(R.id.dugme6);
        dugme6.setOnClickListener(this);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dugme1:
                textView.setText(editText.getText().toString());
                break;

            case R.id.dugme2:
                cntDugme2 ++;
                if(cntDugme2 % 2 == 1) {
                    dugme2.setBackgroundColor(Color.RED);
                    dugme2.setText("ANGRY DUGME 2");
                } else {
                    dugme2.setBackgroundColor(Color.BLUE);
                    dugme2.setText("HAPPY DUGME 2");
                }
                break;

            case R.id.dugme3:
                dugme1.setVisibility(View.GONE);
                dugme2.setVisibility(View.GONE);
                dugme3.setVisibility(View.GONE);
                dugme4.setVisibility(View.GONE);
                dugme5.setVisibility(View.GONE);
                break;

            case R.id.dugme4:
                dugme1.setEnabled(false);
                dugme2.setEnabled(false);
                dugme3.setEnabled(false);
                dugme4.setEnabled(false);
                dugme6.setEnabled(false);
                break;

            case R.id.dugme5:
                dugme1.setEnabled(true);
                dugme2.setEnabled(true);
                dugme3.setEnabled(true);
                dugme4.setEnabled(true);
                dugme6.setEnabled(true);
                break;

            case R.id.dugme6:
                dugme1.setVisibility(View.VISIBLE);
                dugme2.setVisibility(View.VISIBLE);
                dugme3.setVisibility(View.VISIBLE);
                dugme4.setVisibility(View.VISIBLE);
                dugme5.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Stoped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Destroyed");
    }

}
