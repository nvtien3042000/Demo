package com.example.pt_bac2;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private ArrayList <String> arrayList;
    private ArrayAdapter <String> arrayAdapter;
    private ListView listViewSolve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.et_a);
        editTextB = findViewById(R.id.et_b);
        editTextC = findViewById(R.id.et_c);
        listViewSolve = findViewById(R.id.lv_solve);
        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listViewSolve.setAdapter(arrayAdapter);

        listViewSolve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                String data = arrayList.get(i);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });

        listViewSolve.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayList.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    public void clickOnSolveButton(View R){

        double a,b,c;
        try {
            a = Double.parseDouble(editTextA.getText().toString());
            b = Double.parseDouble(editTextB.getText().toString());
            c = Double.parseDouble (editTextC.getText().toString());
        } catch (Exception e){
            Toast.makeText(this, "ERROR!!Please enter the number", Toast.LENGTH_LONG).show();
            return;
        }

        double delta = b*b - 4*a*c;

        String result = a+"x^2 + " + b +"x + "+c+" = 0\n";
        double x1,x2;
        if(delta > 0){
            x1 = (double) ((-b)+Math.sqrt(delta))/(2*a);
            x2 = (double) ((-b)-Math.sqrt(delta))/(2*a);
            result = result+"Phươg trình có 2 nghiệm: x1 = " + x1 + "; x2 = " + x2;
        }else if(delta == 0){
            x1 = (double) (-b)/(2*a);
            x2 = (double) (-b)/(2*a);
            result = result + "Phương trình có nghiệm kép : x1 = x2 = " + x1;
        }else{
            result = result +"Phương trình vô nghiệm";
        }

        arrayList.add(result);
        arrayAdapter.notifyDataSetChanged();
        editTextA.setText("");
        editTextB.setText("");
        editTextC.setText("");
    }
}