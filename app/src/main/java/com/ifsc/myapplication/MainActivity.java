package com.ifsc.imcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAltura, editTextPeso;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alturaStr = editTextAltura.getText().toString();
                String pesoStr = editTextPeso.getText().toString();

                if (!alturaStr.isEmpty() && !pesoStr.isEmpty()) {
                    float altura = Float.parseFloat(alturaStr);
                    float peso = Float.parseFloat(pesoStr);

                    // Enviar dados para a segunda activity
                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                    intent.putExtra("altura", altura);
                    intent.putExtra("peso", peso);
                    startActivity(intent);
                }
            }
        });
    }
}
