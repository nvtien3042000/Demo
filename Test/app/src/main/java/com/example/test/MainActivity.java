package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userPlainText;
    private EditText passwordPlainText;
    private TextView userAndPassTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPlainText = findViewById(R.id.userPlainTest);
        passwordPlainText = findViewById(R.id.passwordPassword);
        userAndPassTextView = findViewById(R.id.userAndpassTextView);
    }

    public void clickOnOkButton(View v){
        userAndPassTextView.setText(""+userPlainText.getText().toString()+"--"+passwordPlainText.getText().toString());
    }
}