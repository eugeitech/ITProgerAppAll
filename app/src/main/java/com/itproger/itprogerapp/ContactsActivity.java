package com.itproger.itprogerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.itproger.itprogerapp.text_editor.MainTextEditorActivity;

public class ContactsActivity extends AppCompatActivity {

    private String[] namesArray = new String[] {"Joan", "Josh", "George", "Bob", "Alex"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.name_item,
                R.id.user_name,
                namesArray
        );
        listView.setAdapter(arrayAdapter);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainTextEditorActivity.class);
        startActivity(intent);
    }
}