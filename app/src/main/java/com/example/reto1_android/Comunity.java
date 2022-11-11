package com.example.reto1_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Comunity  extends AppCompatActivity implements View.OnClickListener{

    private ImageButton Cancelar = null;
    private ImageButton Favoritosboton = null;
    private String nombreUsu ;
    private TextView nombreUsutextView;
    static String USUARIO;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity);

        nombreUsutextView = (TextView) findViewById(R.id.textView2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            nombreUsu = bundle.getString("USUARIOLOG");
        }

       nombreUsutextView.setText(nombreUsu);



        Cancelar = (ImageButton) findViewById( R.id.imageButton);
        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(USUARIO, nombreUsu);
                setResult(RESULT_OK, intent);
                finish();
            }
        });



        Favoritosboton = (ImageButton) findViewById( R.id.imageButton3);
        Favoritosboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityOpcion = new Intent(Comunity.this, Favoritos.class);
                startActivity(ActivityOpcion);
            }

        });




    }


    @Override
    public void onClick(View v) {

    }
}
