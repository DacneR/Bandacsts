package com.javabank.bandacsts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    public int User,Pin,Ip;

    String pNumberSop = "3127848025";
    TextView bolsa;

    Button salir,soporte;

    /*TextView Bag;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        User = getIntent().getIntExtra("user",0);
        Pin = getIntent().getIntExtra("pin",0);
        Ip = getIntent().getIntExtra("ip",0);
        bolsa = findViewById(R.id.idBag);
        salir = findViewById(R.id.BtnClose);
        soporte = findViewById(R.id.BtnSuport);


    }

    public void  onStart(){
        super.onStart();
        actualizarBag();

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        soporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irALlamar(view);
            }
        });
    }


    public void actualizarBag(){
        String bag = "1000000";
        bolsa = findViewById(R.id.idBag);
        bolsa.setText(bag);

    }

    public void irALlamar(View view)
    {
        Intent llamada = new Intent(Intent.ACTION_DIAL);
        llamada.setData(Uri.parse("tel: " + pNumberSop));

        //confirma si la aplicación de teléfono funciona
        if(llamada.resolveActivity(getPackageManager())!=null)
        {
            startActivity(llamada);
        }else
        {
            AlertDialog.Builder alerta = new AlertDialog.Builder(Account.this);
            alerta.setMessage("Fallo al intentar abrir el teléfono")
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
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


}