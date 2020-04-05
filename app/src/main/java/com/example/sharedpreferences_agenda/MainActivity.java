package com.example.sharedpreferences_agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.nombre);
        info = (EditText) findViewById(R.id.description);
    }

    public void add (View view){
        String name = nombre.getText().toString();
        String desc = info.getText().toString();
        SharedPreferences sh = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor she = sh.edit();
        she.putString(name, desc);
        she.commit();

        Toast.makeText(this, "Save!", Toast.LENGTH_SHORT).show();
    }

    public void search (View view){
        String name = nombre.getText().toString();
        SharedPreferences sh = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = sh.getString(name, "");
        if (datos.length() == 0){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }
        else{
            info.setText(datos);
        }
    }
}