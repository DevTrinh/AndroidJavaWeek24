package com.example.week24;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentA extends Fragment {

    TextView tvFragmentA;
    EditText etFragmentA;
    Button btFragmentA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);
        mapping(view);

//        btFragmentA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), etFragmentA.getText().toString()+"", Toast.LENGTH_SHORT).show();
//            }
//        });

        return view;
    }

    public void mapping(@NonNull View view){
        tvFragmentA = view.findViewById(R.id.tv_fragment_a);
        etFragmentA = view.findViewById(R.id.et_fragment_a);
        btFragmentA = view.findViewById(R.id.bt_add_fragment_a);
    }
}
