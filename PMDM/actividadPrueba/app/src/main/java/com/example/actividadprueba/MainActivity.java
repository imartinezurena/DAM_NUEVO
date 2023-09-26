package com.example.actividadprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*Definir atributos para controles*/
    Button btSaluda;
    TextView tvSalida;
    EditText etNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recoger la referencias a los controles de la interfaz
        btSaluda = findViewById(R.id.idBtSaluda);
        tvSalida = findViewById(R.id.idTvSalida);
        etNombre = findViewById(R.id.idTextNombre);

        //manejador de evento
        btSaluda.setOnClickListener((View v)->{
            //magia
            String nombre=etNombre.getText().toString();
            if(nombre.equals("")){
                tvSalida.setText(R.string.holamundo);
            } else if(nombre.equals("mundo")){
                tvSalida.setText("explota");}
            else{
                tvSalida.setText(
                        ("hola")+ nombre);


            }

        });
    }
}