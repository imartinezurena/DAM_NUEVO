package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MisEventos extends AppCompatActivity {
    TextView tv;
    Button bt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_eventos);

        tv = findViewById(R.id.txt01);
        bt = findViewById(R.id.idbutton01);
/*
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(R.string.holamundo);
            }
        });*/

        bt.setOnClickListener((View v)->{
            String estadoActual= tv.getText().toString();
            estadoActual+=getResources().getString(R.string.holamundo);
            tv.setText(estadoActual);
            //tv.append(getResources().getString(R.string.holamundo));
            });

    }
}