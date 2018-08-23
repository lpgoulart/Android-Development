package com.example.asynctask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Button btnButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnButton = findViewById(R.id.btnIniciar);
        textView = findViewById(R.id.text_counter);

    }

    public void iniciar(View view) {
        CounterTask task = new CounterTask(textView,btnButton);
        task.execute(10);
    }
}
