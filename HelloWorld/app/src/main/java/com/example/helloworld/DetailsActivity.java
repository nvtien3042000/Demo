package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvNumber = findViewById(R.id.tv_number);
        Intent intent = getIntent();
        if(intent != null){
            String data = intent.getStringExtra("data");
            tvNumber.setText(data);
        }
    }
}