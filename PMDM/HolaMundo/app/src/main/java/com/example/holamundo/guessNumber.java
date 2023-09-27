package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class guessNumber extends AppCompatActivity {
    Button btnGuess;
    Button btnRestart;
    TextView tvClue;
    EditText ptNumber;
    int numeroMisterioso;
    Random r ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);
        r=new Random();
        numeroMisterioso=r.nextInt(100)+1;

        btnGuess=findViewById(R.id.btIdGuess);
        btnRestart=findViewById(R.id.btIdRestart);
        tvClue=findViewById(R.id.TvIdClue);
        ptNumber=findViewById(R.id.eTIdNumber);

        btnGuess.setOnClickListener(view -> {


        int aux = Integer.parseInt( ptNumber.getText().toString());
        if (aux==numeroMisterioso){ tvClue.setText(R.string.VictoryClue);}
        else if (aux<numeroMisterioso) {tvClue.setText(String.format("%s%s", getResources().getString(R.string.mayorClue), ptNumber.getText().toString()));}
        else {tvClue.setText(R.string.menorClue);}
            ptNumber.setText("");

        });
    }

}