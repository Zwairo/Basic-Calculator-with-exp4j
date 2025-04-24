package com.example.beginnercods;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView sonuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        sonuc = findViewById(R.id.textView1);

        int[] buttonIDs = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9,
                R.id.button10, R.id.button11, R.id.button12, R.id.button13,R.id.button14,R.id.button15

        };

        for (int id : buttonIDs) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v -> {
                String current = sonuc.getText().toString();
                String clicked = btn.getText().toString();

                if (clicked.equals("=")) {
                    try {
                        // Basit hesaplama yap
                        Expression expression = new ExpressionBuilder(current).build();
                        double result = expression.evaluate();
                        sonuc.setText(String.valueOf(result));
                    } catch (Exception e) {
                        sonuc.setText("Hata");
                    }
                } else if (clicked.equals("C")) {
                    sonuc.setText("".toString());
                } else {
                    sonuc.setText(current + clicked);
                }
            });
        }

    }





}