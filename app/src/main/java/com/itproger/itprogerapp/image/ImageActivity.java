package com.itproger.itprogerapp.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.itproger.itprogerapp.R;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    }

    public void goToSecondActivity(View view) {
        Intent intent = new Intent(this, ImageSecondActivity.class);
        startActivity(intent);
    }
}
