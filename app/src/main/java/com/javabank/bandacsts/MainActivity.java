package com.javabank.bandacsts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button logueo;

    EditText User,Pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User = findViewById(R.id.TxtUser);
        Pin = findViewById(R.id.TxtPin);
        logueo = findViewById(R.id.BtnLogueo);
    }

    @Override
    public  void onStart(){
        super.onStart();

        logueo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.parseInt(User.getText().toString())==1017922915 && Integer.parseInt(Pin.getText().toString())==7777)
                {
                    enviarDatos(view);
                }else
                {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Contraseña y/o usuario incorrecto")
                            .setCancelable(false)
                            .setPositiveButton("Intentar de nuevo", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });

                    AlertDialog titulo = alerta.create();
                    titulo.setTitle("Error");
                    titulo.show();
                }
            }
        });



    }

    public void enviarDatos(View view){
        int u = Integer.parseInt(User.getText().toString());
        int p = Integer.parseInt(Pin.getText().toString());


        Intent pasar = new Intent(this,Account.class);

        pasar.putExtra("user",u);
        pasar.putExtra("pin",p);


        startActivity(pasar);

    }



}