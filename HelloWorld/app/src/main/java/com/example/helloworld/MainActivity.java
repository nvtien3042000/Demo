package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvCounter;
    private int count;
    private ArrayList <String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    private ListView lvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tv_counter);
        count = 1;
        lvNumber = findViewById(R.id.lv_number);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvNumber.setAdapter(arrayAdapter);
        lvNumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                String data = arrayList.get(i);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });

        lvNumber.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    public void clickOnCounterButton(View v){
        tvCounter.setText("" + count);
        arrayList.add("" + count);
        arrayAdapter.notifyDataSetChanged();
        count++;
    }
}