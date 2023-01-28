package com.itproger.itprogerapp.popup_messages;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itproger.itprogerapp.R;

public class PopupMessagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_messages);

        TextView mainText = findViewById(R.id.mainText);
        Button buttonSecond = findViewById(R.id.bth_second);

        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showInfo((String)mainText.getText(), buttonSecond);
                showInfoAlert("Do you wont to close this application?");
            }
        });
    }

    public void buttonClick(View view) {
        showInfo(((Button)view).getText().toString(), ((Button) view));
    }

    private void showInfoAlert(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(PopupMessagesActivity.this);
        builder.setTitle("Big hint")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfo(String text, Button button) {
        button.setText("Pressed");
        button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}