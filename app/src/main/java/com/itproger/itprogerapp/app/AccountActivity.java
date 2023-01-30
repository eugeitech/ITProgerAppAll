package com.itproger.itprogerapp.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itproger.itprogerapp.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountActivity extends AppCompatActivity {

    private EditText userNameField, userBioField;
    private Button blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        userNameField = findViewById(R.id.user_name_field);
        userBioField = findViewById(R.id.user_bio_field);
        blog = findViewById(R.id.blog);

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeb(v);
            }
        });
    }

    public void saveDate(View view) {
        String userName = userNameField.getText().toString();
        String userBio = userBioField.getText().toString();

        try {
            FileOutputStream fileOutputStream = openFileOutput("user_data.txt", MODE_PRIVATE);
            fileOutputStream.write((userName + ", " + userBio).getBytes());
            fileOutputStream.close();

            userNameField.setText("");
            userBioField.setText("");

            Toast.makeText(this, "Text is saved", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Cannot process the file", Toast.LENGTH_SHORT).show();
        }
    }

    public void getDate(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("user_data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String lines;
            while((lines = bufferedReader.readLine()) != null) {
                stringBuilder.append(lines).append("\n");
            }

            Toast.makeText(this, stringBuilder, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goContacts(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void goWeb(View view) {
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }
}
