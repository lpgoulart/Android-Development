package com.example.frag_communication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements textFragment.OnInvertListener{

    private resultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultFragment = (resultFragment) getFragmentManager().findFragmentById(R.id.frag_result);

    }

    @Override
    public void onInvert(String txt) {
        resultFragment.invert(txt);
    }
}
