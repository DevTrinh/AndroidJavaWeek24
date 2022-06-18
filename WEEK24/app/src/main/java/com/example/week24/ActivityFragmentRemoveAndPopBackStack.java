package com.example.week24;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ActivityFragmentRemoveAndPopBackStack extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_remove_and_pop_back_stack);

    }

    public void addA(View view) {
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.add(R.id.ll_display_fragment_remove_pop,
                new FragmentRemoveA(), "FRAGMENT A");
        fragmenttransaction.addToBackStack("AddBackStackA");
        fragmenttransaction.commit();
    }

    public void addB(View view) {
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.add(R.id.ll_display_fragment_remove_pop,
                new FragmentRemoveB(), "FRAGMENT B");
        fragmenttransaction.addToBackStack("AddBackStackB");
        fragmenttransaction.commit();
    }

    public void addC(View view) {
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        fragmenttransaction.add(R.id.ll_display_fragment_remove_pop,
                new FragmentRemoveC(), "FRAGMENT C");
        fragmenttransaction.addToBackStack("AddBackStackC");
        fragmenttransaction.commit();
    }

    public void removeA(View view) {
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        FragmentRemoveA fragmentA =
                (FragmentRemoveA) getFragmentManager().findFragmentByTag("F");
        if (fragmentA != null) {
            fragmenttransaction.remove(fragmentA);
            fragmenttransaction.commit();
        } else {
            Toast.makeText(this,
                    "Fragment not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void removeB(View view) {
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        FragmentRemoveB fragmentB =
                (FragmentRemoveB) getFragmentManager().findFragmentByTag("FRAGMENT B");
        if (fragmentB != null) {
            fragmenttransaction.remove(fragmentB);
            fragmenttransaction.commit();
        } else {
            Toast.makeText(this,
                    "Fragment not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void removeC(View view) {
        FragmentTransaction fragmenttransaction = fragmentManager.beginTransaction();
        FragmentRemoveC fragmentC =
                (FragmentRemoveC) getFragmentManager().findFragmentByTag("FRAGMENT C");
        if (fragmentC != null) {
            fragmenttransaction.remove(fragmentC);
            fragmenttransaction.commit();
        } else {
            Toast.makeText(this,
                    "Fragment not exist", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        getFragmentManager().popBackStack();
    }

    public void popA(View view) {
        getFragmentManager().popBackStack("AddBackStackA", 0);
    }

    @Override
    public void onBackPressed() {
//        TEST IN STACK COUNT FRAGMENT > 0 RETURN FRAGMENT BEFORE
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}