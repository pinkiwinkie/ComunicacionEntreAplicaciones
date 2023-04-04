package com.example.comunicacionentreaplicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button bVerificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bVerificar = findViewById(R.id.verificar);
        bVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarVerificar(null);
            }
        });
    }

    private void lanzarVerificar(View view) {
        Intent i = new Intent(this, Verificar.class);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        i.putExtra("name",editText.getText().toString());
        startActivity(i);
    }
}