package com.example.week24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFragmentEvent extends AppCompatActivity {

    TextView tvMain;
    Button btChangeText;
    FragmentEventA fragmentEventA;
    FragmentEventB fragmentEventB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_event);

        mapping();

        btChangeText.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                tvMain.setText(fragmentEventA.etFragmentEventA.getText().toString()
                        + fragmentEventB.etFragmentEventB.getText().toString());
            }
        });
    }

    public void mapping() {
        tvMain = findViewById(R.id.tv_fragment_event);
        btChangeText = findViewById(R.id.bt_fragment_change_text);
        fragmentEventA = (FragmentEventA) getFragmentManager().findFragmentById(R.id.fr_a);
        fragmentEventB = (FragmentEventB) getFragmentManager().findFragmentById(R.id.fr_b);
    }
}