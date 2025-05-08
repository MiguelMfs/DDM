package com.ifsc.sorteionum; 

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMin, editTextMax;
    private Button buttonSortear;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        buttonSortear = findViewById(R.id.buttonSortear);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String minString = editTextMin.getText().toString();
                String maxString = editTextMax.getText().toString();

                if (!minString.isEmpty() && !maxString.isEmpty()) {
                    int min = Integer.parseInt(minString);
                    int max = Integer.parseInt(maxString);

                    if (min > max) {
                        textViewResultado.setText("O valor mínimo não pode ser maior que o máximo!");
                    } else {
                        Random random = new Random();
                        int numeroSorteado = random.nextInt((max - min) + 1) + min;

                        textViewResultado.setText("Número sorteado: " + numeroSorteado);
                    }
                } else {
                    textViewResultado.setText("Por favor, preencha os dois valores.");
                }
            }
        });
    }
}
