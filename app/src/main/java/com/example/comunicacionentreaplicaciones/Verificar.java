package com.example.comunicacionentreaplicaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Verificar extends AppCompatActivity {

    private Button bAccept, bCancel;
    @Override
    public  void onCreate(Bundle savedInstace){
        super.onCreate(savedInstace);
        bAccept = findViewById(R.id.aceptar);
        bCancel = findViewById(R.id.rechazar);
        setContentView(R.layout.verificar);
        TextView textView = findViewById(R.id.textViewWithInformation);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        textView.setText("Hola " + name+", ¿Aceptas las condiciones?");

        bAccept.setOnClickListener(view -> {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            intent.putExtra("resultado", "Condiciones aceptadas");
            finish();
        });

        bCancel.setOnClickListener(view -> {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        });
    }
}
