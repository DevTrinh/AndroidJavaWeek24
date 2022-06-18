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

public class FragmentEventB extends Fragment {
    TextView tvFragmentEventB;
    Button btFragmentEventB;
    EditText etFragmentEventB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event_b, container, false);
        mapping(view);

        btFragmentEventB. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        etFragmentEventB.getText().toString()+"",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void mapping(@NonNull View view){
        tvFragmentEventB = view.findViewById(R.id.tv_fragment_event_b);
        etFragmentEventB = view.findViewById(R.id.et_fragment_event_b);
        btFragmentEventB = view.findViewById(R.id.bt_fragment_event_b);
    }
}
