package com.example.week24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class ActivityFragmentIntroduce extends AppCompatActivity {

    Button btAddFragmentA, btAddFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        mapping();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.it_home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void mapping() {
        btAddFragmentA = findViewById(R.id.bt_add_fragment_a);
        btAddFragmentB = findViewById(R.id.bt_add_fragment_b);
    }

    @SuppressLint("NonConstantResourceId")
    public void addFragment(@NonNull View view) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.bt_add_fragment_a:
                fragment = new FragmentA();
                break;
            case R.id.bt_add_fragment_b:
                fragment = new FragmentB();
                break;
        }
        fragmentTransaction.replace(R.id.fr_contain_fragment_top, fragment);
        fragmentTransaction.commit();
    }
}