package com.juan.gamarra.tarea1activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    private EditText nombre,telefono, email, descripcion ;
    private DatePicker fecha;
    private Bundle devolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        siguiente = (Button) findViewById(R.id.siguiente);

        nombre = (EditText) findViewById(R.id.nombre);
        telefono = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);
        descripcion = (EditText) findViewById(R.id.descripcion);
        fecha = (DatePicker) findViewById(R.id.datePicker);

        siguiente.setOnClickListener(siguienteVista);

        devolver = getIntent().getExtras();


        if(devolver!= null && !devolver.isEmpty()){

            nombre.setText(devolver.getString("nombre"));
            telefono.setText(devolver.getString("telefono"));
            fecha.init(Integer.parseInt(devolver.getString("año")), Integer.parseInt(devolver.getString("mes")),Integer.parseInt(devolver.getString("fecha")),null);
            email.setText(devolver.getString("email"));
            descripcion.setText(devolver.getString("descripcion"));

        }



    }
    View.OnClickListener siguienteVista = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =  new Intent(MainActivity.this,Detalles.class);
            intent.putExtra("nombre",nombre.getText().toString());
            intent.putExtra("telefono",telefono.getText().toString());
            intent.putExtra("email",email.getText().toString());
            intent.putExtra("descripcion",descripcion.getText().toString());
            intent.putExtra("fecha",String.valueOf(fecha.getDayOfMonth()));
            intent.putExtra("mes",String.valueOf(fecha.getMonth()));
            intent.putExtra("año",String.valueOf(fecha.getYear()));
            startActivity(intent);
            finish();

        }
    };
}
