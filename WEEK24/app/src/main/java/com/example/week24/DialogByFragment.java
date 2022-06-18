package com.example.week24;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.week24.interfacee.DialogAction;
import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class DialogByFragment extends DialogFragment {

    DialogAction dialogAction;

    private final int position;
    private final ArrayList<String> arrListItem;
    public ArrayAdapter adapter;

    public DialogByFragment(int position, ArrayList<String>  arrListItem, ArrayAdapter adapter) {
        this.position = position;
        this.arrListItem = arrListItem;
        this.adapter = adapter;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialogAction = (DialogAction) getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Warning !");
        builder.setMessage("Do you want delete item ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogAction.deleteItem(arrListItem, position, adapter, true);
            }
        }).setNegativeButton("Not now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        Dialog dialog = builder.create();
        return dialog;
    }
}
