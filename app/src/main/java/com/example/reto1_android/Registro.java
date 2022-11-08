package com.example.reto1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity implements View.OnClickListener{
    private Button Aceptar = null;
    private ImageButton Cancelar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        Aceptar = (Button) findViewById(R.id.button6);
        Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(Registro.this, MainActivity.class);
                startActivity(ActivityOpcion);
            }

        });


        Cancelar = (ImageButton) findViewById(R.id.imageButton2);
        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(Registro.this, MainActivity.class);
                startActivity(ActivityOpcion);
            }

        });










    }


    @Override
    public void onClick(View v) {

    }
}
