package com.example.week24.interfacee;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public interface DialogAction {
     void deleteItem(ArrayList<String> list, int position, ArrayAdapter adapter, boolean delete);
}
