package com.example.frag_communication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class resultFragment extends Fragment {

    private TextView txtInverted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_result, container,false);

        txtInverted = view.findViewById(R.id.txt_text);

        return view;
    }

    public void invert (String text) {
        if (text != null) {
            String inverted = new StringBuilder().reverse().toString();
            txtInverted.setText(inverted);
        }

    }
}
