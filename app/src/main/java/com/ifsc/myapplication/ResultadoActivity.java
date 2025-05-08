package com.ifsc.imcapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewResultado = findViewById(R.id.textViewResultado);

        // Recuperar os dados enviados pela MainActivity
        float altura = getIntent().getFloatExtra("altura", 0);
        float peso = getIntent().getFloatExtra("peso", 0);

        float imc = peso / (altura * altura);
        String classificacao;

        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc < 24.9) {
            classificacao = "Peso normal";
        } else if (imc < 29.9) {
            classificacao = "Sobrepeso";
        } else {
            classificacao = "Obesidade";
        }

        textViewResultado.setText(String.format("IMC: %.2f\nClassificação: %s", imc, classificacao));
    }
}
