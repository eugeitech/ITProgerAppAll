package com.itproger.itprogerapp.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.itproger.itprogerapp.R;

public class MainCalculatorActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText numberField1;
    private EditText numberField2;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        resultTextView = findViewById(R.id.resultTextView);
        numberField1 = findViewById(R.id.number_field_1);
        numberField2 = findViewById(R.id.number_field_2);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1 = Float.parseFloat(numberField1.getText().toString());
                float num2 = Float.parseFloat(numberField2.getText().toString());
                float res = num1 + num2;
                resultTextView.setText(String.valueOf(res));
            }
        });
    }
}