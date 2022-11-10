package com.example.reto1_android;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.beans_SQLite.Client;
import com.example.datamanager_SQLite.DataManager;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button botonRegistro = null;
    private Button entrarComunity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*-------------------SQLite---------------------*/
        /*Funcion de CheckBox*/
        DataManager dataManager = new DataManager(this);

        ((EditText) findViewById( R.id.editTextTextPersonName )).addTextChangedListener( registerEditTextListener );
        ((EditText) findViewById( R.id.editTextTextPassword )).addTextChangedListener( registerEditTextListener );
        CheckBox checkBox = (CheckBox) findViewById (R.id.checkBox);

        ((EditText) findViewById( R.id.editTextTextPersonName )).setText( dataManager.selectUltimo().getLoginUser() );
        ((EditText) findViewById( R.id.editTextTextPassword )).setText( dataManager.selectUltimo().getPass());


        entrarComunity = (Button) findViewById( R.id.button2);
        entrarComunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = ((EditText) findViewById( R.id.editTextTextPersonName )).getText().toString();
                String Pass = ((EditText) findViewById( R.id.editTextTextPassword )).getText().toString();


                if (checkBox.isChecked()) {

                    boolean found = false;
                    if (!dataManager.isEmpty()) {
                        List<Client> clients = dataManager.selectAllClients();

                        for (Client client : clients) {
                            found = (client.getLoginUser().equals(name)) && (client.getPass().equals(Pass));
                            if (found)
                                break;
                        }
                    }

                    if (!found) {
                        try {
                            Client cliente = new Client();
                            cliente.setLoginUser(name);
                            cliente.setPass(Pass);

                            dataManager.insert(cliente);

                            Toast.makeText(getApplicationContext(),"Cliente Guardado", Toast.LENGTH_SHORT);

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),"Error de BBDD", Toast.LENGTH_SHORT);
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),"Cliente Repetido", Toast.LENGTH_SHORT);
                    }
                }

                startActivity(new Intent(MainActivity.this, Comunity.class));



            }

        });

        botonRegistro = (Button) findViewById( R.id.button3);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }

        });




    }

    @Override
    public void onClick(View v) {




    }


    //------------------------- EditText Events -------------------------//

    /**
     * Disables the list button if editTexts are empty
     */
    private final TextWatcher registerEditTextListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String name = ((EditText) findViewById( R.id.editTextTextPersonName )).getText().toString();
            String Pass = ((EditText) findViewById( R.id.editTextTextPassword )).getText().toString();


            (findViewById( R.id.button2 )).setEnabled( !TextUtils.isEmpty( name ) && !TextUtils.isEmpty( Pass ));
        }
    };






}