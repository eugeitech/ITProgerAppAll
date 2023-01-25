package com.itproger.itprogerapp.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.itproger.itprogerapp.R;

public class MainFragmentsActivity extends AppCompatActivity {

    private Button buttonFragment1, buttonFragment2;
    private FrameLayout frameLayout;
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragments);

        buttonFragment1 = findViewById(R.id.button_fragment_1);
        buttonFragment2 = findViewById(R.id.button_fragment_2);
        frameLayout = findViewById(R.id.frame_layout);

        setNewFragment(firstFragment);

        buttonFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(firstFragment);
            }
        });

        buttonFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(secondFragment);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}