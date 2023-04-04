package com.example.comunicacionentreaplicaciones;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Verificar extends AppCompatActivity {
    @Override
    public  void onCreate(Bundle savedInstace){
        super.onCreate(savedInstace);
        setContentView(R.layout.verificar);
        TextView textView = findViewById(R.id.textViewWithInformation);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        textView.setText("Hola " + name+", ¿Aceptas las condiciones?");
    }
}
