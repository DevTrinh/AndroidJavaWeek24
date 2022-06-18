package com.example.week24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityFragmentBundle extends AppCompatActivity {

    Button btMainFragmentBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_bundle);
        mapping();

//        btMainFragmentBundle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void mapping(){
        btMainFragmentBundle = findViewById(R.id.bt_main_fragment_bundle);
    }

    public void addFragmentBundle(View view) {
        FragmentBundle fragmentBundle = new FragmentBundle();
        Bundle bundleActivityToFragment = new Bundle();
        bundleActivityToFragment.putString("AHIHI", "Truyền bởi bundle !");
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentBundle.setArguments(bundleActivityToFragment);
        fragmentTransaction.add(R.id.fr_main_fragment_bundle, fragmentBundle);
        fragmentTransaction.commit();
    }
}