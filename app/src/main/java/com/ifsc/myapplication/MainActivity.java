package com.ifsc.contaclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private Button buttonClick;
    private TextView textViewClicks;
    private int clickCount = 0; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = findViewById(R.id.buttonClick);
        textViewClicks = findViewById(R.id.textViewClicks);

        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                textViewClicks.setText("Número de Cliques: " + clickCount);
            }
        });
    }
}
