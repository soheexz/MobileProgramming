package com.android.mobileprogramming14;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment2 extends Fragment {

    TextView edtOutput;
    Button btnOutput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_2, container, false);

        edtOutput = rootView.findViewById(R.id.edtOutput);
        btnOutput = rootView.findViewById(R.id.btnOutput);

        if(getArguments() != null){
            String tmp = getArguments().getString("key");
            edtOutput.setText(tmp);
        }

        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                ft.replace(R.id.rootlayout,fragment1).commit();
            }
        });

        return rootView;
    }
}