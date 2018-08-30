package com.example.frag_communication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class textFragment extends Fragment implements View.OnClickListener{

    private EditText edtText;
    private Button btn;

    private OnInvertListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof  OnInvertListener)) {
            throw new RuntimeException("Deve ser OnInvertedListener");
        }

        listener = (OnInvertListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_text,container,false);
        edtText = view.findViewById(R.id.editText);
        btn = view.findViewById(R.id.btnButton);

        btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            String texto = edtText.getText().toString();
            listener.onInvert(texto);
        }
    }

    public interface OnInvertListener {
        public void onInvert(String txt);
    }
}
