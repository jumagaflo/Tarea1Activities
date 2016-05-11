package com.juan.gamarra.tarea1activities;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    Button editar;
    private TextView nombre, fecha, telefono, email, descripcion;
    private Bundle parametros;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        editar = (Button) findViewById(R.id.editar);

        parametros = getIntent().getExtras();

        nombre = (TextView) findViewById(R.id.nombre);
        fecha = (TextView) findViewById(R.id.fecha);
        telefono = (TextView) findViewById(R.id.telefono);
        email = (TextView) findViewById(R.id.email);
        descripcion = (TextView) findViewById(R.id.descripcion);


        nombre.setText(parametros.getString("nombre"));
        fecha.setText(parametros.getString("fecha")+"/"+parametros.getString("mes")+"/"+parametros.getString("año"));
        telefono.setText(parametros.getString("telefono"));
        email.setText(parametros.getString("email"));
        descripcion.setText(parametros.getString("descripcion"));

        editar.setOnClickListener(anteriorVista);


    }
    View.OnClickListener anteriorVista = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Detalles.this,MainActivity.class);
            intent.putExtra("nombre",parametros.getString("nombre"));
            intent.putExtra("telefono",parametros.getString("telefono"));
            intent.putExtra("email",parametros.getString("email"));
            intent.putExtra("descripcion",parametros.getString("descripcion"));
            intent.putExtra("fecha",parametros.getString("fecha"));
            intent.putExtra("mes",parametros.getString("mes"));
            intent.putExtra("año",parametros.getString("año"));
            startActivity(intent);
            finish();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Detalles.this,MainActivity.class);
            startActivity(intent);
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }
}
