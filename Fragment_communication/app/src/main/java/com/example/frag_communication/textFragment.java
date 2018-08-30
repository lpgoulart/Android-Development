package com.example.frag_communication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class textFragment extends Fragment{

    private EditText edittext;
    private Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_text,container,false);
        edittext = view.findViewById(R.id.editText);
        btn = view.findViewById(R.id.btnButton);

        return view;
    }
}
