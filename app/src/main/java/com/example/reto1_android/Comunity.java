package com.example.reto1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Comunity  extends AppCompatActivity implements View.OnClickListener{

    private ImageButton Cancelar = null;
    private ImageButton Favoritosboton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity);






        Favoritosboton = (ImageButton) findViewById( R.id.imageButton3);
        Favoritosboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(Comunity.this, Favoritos.class);
                startActivity(ActivityOpcion);
            }

        });


        Cancelar = (ImageButton) findViewById( R.id.imageButton);
        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(Comunity.this, MainActivity.class);
                startActivity(ActivityOpcion);
            }

        });




    }


    @Override
    public void onClick(View v) {

    }
}
