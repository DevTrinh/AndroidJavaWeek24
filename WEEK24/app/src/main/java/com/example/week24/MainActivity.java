package com.example.week24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.it_webservice:
                startActivity(new Intent(this,
                        WebServiceReturnJSON.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
            case R.id.it_fragment_layout:
                startActivity(new Intent(this,
                        ActivityFragmentIntroduce.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                Toast.makeText(this, "Fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it_fragment_event:
                startActivity(new Intent(this,
                        ActivityFragmentEvent.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
            case R.id.it_fragment_bundle:
                startActivity(new Intent(this,
                        ActivityFragmentBundle.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
            case R.id.it_fragment_remove_popbackstack:
                startActivity(new Intent(this,
                        ActivityFragmentRemoveAndPopBackStack.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
            case R.id.it_list_fragment:
                startActivity(new Intent(this,
                        ListFragmentTest.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
            case R.id.it_app_music:
                startActivity(new Intent(this,
                        AppMusic.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
            case R.id.it_note_app:
                startActivity(new Intent(this,
                        SQLiteToDoList.class));
                overridePendingTransition(R.anim.anim_begin, R.anim.anim_end);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}