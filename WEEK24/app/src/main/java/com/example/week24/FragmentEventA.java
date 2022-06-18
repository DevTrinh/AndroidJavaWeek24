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

public class FragmentEventA extends Fragment {
    TextView tvFragmentEventA;
    EditText etFragmentEventA;
    Button btFragmentEventA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_event_a, container, false);
        mapping(view);

        btFragmentEventA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        etFragmentEventA.getText().toString()+"",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public void mapping(@NonNull View view){
        tvFragmentEventA = view.findViewById(R.id.tv_fragment_event_a);
        etFragmentEventA = view.findViewById(R.id.et_fragment_event_a);
        btFragmentEventA = view.findViewById(R.id.bt_fragment_event_a);
    }
}
