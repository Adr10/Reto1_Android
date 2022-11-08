package com.example.reto1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Favoritos extends AppCompatActivity implements View.OnClickListener {



    private ImageButton Cancelar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);







        Cancelar = (ImageButton) findViewById( R.id.imageButton5);
        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(Favoritos.this, Comunity.class);
                startActivity(ActivityOpcion);
            }

        });
    }

    @Override
    public void onClick(View v) {

    }
}
