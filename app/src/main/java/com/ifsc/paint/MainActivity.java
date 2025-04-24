package com.ifsc.paint;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    private PaintView paintView;
    private int currentColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criar e adicionar PaintView dinamicamente
        paintView = new PaintView(this);
        FrameLayout container = findViewById(R.id.paintContainer);
        container.addView(paintView);

        // Botões
        Button btnDraw = findViewById(R.id.btnDraw);
        Button btnCircle = findViewById(R.id.btnCircle);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnRectangle = findViewById(R.id.btnRectangle);
        Button btnColor = findViewById(R.id.btnColor);

        btnColor.setOnClickListener(v -> showColorPicker());
        btnDraw.setOnClickListener(v -> paintView.setDrawingMode(PaintView.DrawingMode.PATH));
        btnCircle.setOnClickListener(v -> paintView.setDrawingMode(PaintView.DrawingMode.CIRCLE));
        btnClear.setOnClickListener(v -> paintView.clear());
        btnRectangle.setOnClickListener(v -> paintView.setDrawingMode(PaintView.DrawingMode.RECTANGLE));
    }

    private void showColorPicker() {
        final String[] colorNames = {"Preto", "Vermelho", "Verde", "Azul", "Amarelo", "Roxo"};
        final int[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escolha uma cor");

        builder.setItems(colorNames, (dialog, which) -> {
            int selectedColor = colors[which];
            paintView.setPaintColor(selectedColor);
        });

        builder.show();
    }
}
