package com.example.exemplo_01;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class MyHandler extends Handler {

    private TextView textView;
    private Button btnButton;

    public MyHandler (TextView txt, Button btn) {
        this.textView = txt;
        this.btnButton = btn;
    }

    @Override
    public void handleMessage(Message msg) {
        if( msg.what == 100 ) {
            textView.setText("Processamento finalizado...");
            btnButton.setEnabled(true);
        }
    }
}
