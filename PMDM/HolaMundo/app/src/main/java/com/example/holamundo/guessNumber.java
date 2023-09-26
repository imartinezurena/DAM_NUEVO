package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class guessNumber extends AppCompatActivity {
    Button btnGuess;
    Button btnRestart;
    TextView tvClue;
    EditText ptNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_number);

        btnGuess.findViewById(R.id.btIdGuess);
        btnRestart.findViewById(R.id.btIdRestart);
        tvClue.findViewById(R.id.TvIdClue);
        ptNumber.findViewById(R.id.eTIdNumber);
    }

}