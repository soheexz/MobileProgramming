package com.android.mobileprogramming14;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    EditText edtInput;
    Button btnInput;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Log.i("life-F","onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("life-F","onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("life-F","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("life-F","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("life-F","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("life-F","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("life-F","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("life-F","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("life-F","onDetach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        Log.i("life-F","onCreateView");

        edtInput = rootView.findViewById(R.id.edtInput);
        btnInput = rootView.findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = edtInput.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("key",temp);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                ft.replace(R.id.rootlayout, fragment2);
                ft.commit();
            }
        });

        return rootView;
    }
}