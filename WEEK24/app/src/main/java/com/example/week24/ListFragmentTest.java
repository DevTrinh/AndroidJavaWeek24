package com.example.week24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.week24.interfacee.DialogAction;
import com.example.week24.interfacee.InterfaceSelection;

import java.util.ArrayList;

public class ListFragmentTest extends AppCompatActivity implements DialogAction {

    ImageView ivFragmentDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);
        Toast.makeText(this, "List Fragment Manage",
                Toast.LENGTH_SHORT).show();
        mapping();
    }

    public void mapping() {
        ivFragmentDialog = findViewById(R.id.iv_fragment_dialog);
    }


    @Override
    public void deleteItem(ArrayList<String> list, int position,
                           ArrayAdapter adapter, boolean delete) {
        if (delete) {
            list.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this,
                    "Delete Complete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "<3", Toast.LENGTH_SHORT).show();
        }
    }
}