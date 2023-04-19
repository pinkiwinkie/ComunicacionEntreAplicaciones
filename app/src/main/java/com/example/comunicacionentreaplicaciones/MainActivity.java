package com.example.comunicacionentreaplicaciones;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button bVerificar;
private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bVerificar = findViewById(R.id.verificar);
        tvResult = findViewById(R.id.tvResultAccept);



        ActivityResultLauncher<Intent> someActivityResultLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {
// No es necesario identificar la actividad que envia resultados
                            if(result.getResultCode() == RESULT_CANCELED)
                                Toast.makeText(this, "Cancelado por el usuario",
                                        Toast.LENGTH_LONG).show();
                            else if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent data = result.getData();
                                String usuario = data.getExtras().getString("resultado");
                                tvResult.setText(usuario);
                            }
                        });

        bVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(this, Verificar.class);
                EditText editText = findViewById(R.id.editTextTextPersonName);
                i.putExtra("name",editText.getText().toString());
                someActivityResultLauncher.launch(i);
            }
        });
    }


    }

