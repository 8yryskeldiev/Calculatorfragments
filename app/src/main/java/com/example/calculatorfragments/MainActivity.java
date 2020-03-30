package com.example.calculatorfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    SharedFragment sharedFragment;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculation = findViewById(R.id.calculation);
        calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculationFragment();
            }
        });
        Button share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShareFragment();
            }
        });
    }

    public void setupFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void openCalculationFragment() {
        setupFragments(new CalculationFragment());
    }

    public void openShareFragment() {
        if (text == null) {
            setupFragments(new SharedFragment());
        } else if (text != null) {
            sharedFragment = new SharedFragment();
            Bundle bundle = new Bundle();
            bundle.putString("result", text);
            sharedFragment.setArguments(bundle);
            Log.d("ololo", text);
            setupFragments(sharedFragment);
            setupFragments(sharedFragment);
        }
    }

    public void onInputNumber(String number) {
        text = number;
    }
}

    



