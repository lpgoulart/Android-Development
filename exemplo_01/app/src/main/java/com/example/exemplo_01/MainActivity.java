package com.example.exemplo_01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    private Button btnButton;
//    private Handler handler = new Handler();
    private MyHandler myHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_status);
        btnButton = findViewById(R.id.btnProcessar);
        myHandler = new MyHandler(textView, btnButton);

    }

    public void processar(View view) {

        textView.setText("Processando");
        btnButton.setEnabled(false);
        executarAlgoDemorado();

    }

    public void executarAlgoDemorado() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("Processamento finalizado");
//                        btnButton.setEnabled(true);
//                    }
//                });
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText("Processamento finalizado");
//                        btnButton.setEnabled(true);
//                    }
//                });

                Message msg = Message.obtain();
                msg.what = 100;
                myHandler.sendMessage(msg);
            }
        }).start();


    }



}
