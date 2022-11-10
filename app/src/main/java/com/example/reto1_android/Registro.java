package com.example.reto1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity implements View.OnClickListener{
    private Button Aceptar = null;
    private ImageButton Cancelar = null;
    private EditText pass = null;
    private EditText passDos = null;
    private boolean respuesta = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        Aceptar = (Button) findViewById(R.id.button6);
        Aceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                comprovacionPass();
                comprovacionUsuarioRegistrado();
                if (respuesta== true){
                    startActivity(new Intent(Registro.this, MainActivity.class));

                }

            }

        });


        Cancelar = (ImageButton) findViewById(R.id.imageButton2);
        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro.this, MainActivity.class));
            }

        });



    }

    public boolean comprovacionPass(){

        pass = (EditText) findViewById(R.id.editTextTextPassword);
        passDos = (EditText) findViewById(R.id.editTextTextPassword2);

            if (pass.equals(passDos)){
            respuesta= true;
             }
        return respuesta;
    }

    public boolean comprovacionUsuarioRegistrado(){

        /* Necesario pedir USER de la BBD */



        return respuesta;
    }


    @Override
    public void onClick(View v) {

    }
}
