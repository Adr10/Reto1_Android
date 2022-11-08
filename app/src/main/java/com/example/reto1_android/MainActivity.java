package com.example.reto1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonRegistro = null;
    private Button entrarComunity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonRegistro = (Button) findViewById( R.id.button3);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(MainActivity.this, Registro.class);
                startActivity(ActivityOpcion);
            }

        });


        entrarComunity = (Button) findViewById( R.id.button2);
        entrarComunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(MainActivity.this, Comunity.class);
                startActivity(ActivityOpcion);
            }

        });












    }
    @Override
    public void onClick(View v) {

    }
}