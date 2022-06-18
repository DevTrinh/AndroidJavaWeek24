package com.example.week24;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FragmentBundle extends Fragment {

    TextView tvMainFragmentBundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bundle, container, false);
        mapping(view);

        Bundle bundleGetDataInMain = getArguments();
        if (bundleGetDataInMain != null) {
            String data = bundleGetDataInMain.getString("AHIHI");
            tvMainFragmentBundle.setText(data);
        }
        return view;
    }

    public void mapping(@NonNull View view) {
        tvMainFragmentBundle = view.findViewById(R.id.tv_fragment_bundle);
    }
}
