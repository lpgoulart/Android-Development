package com.example.project_02;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textConteudo;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textConteudo = findViewById(R.id.context);
        progress = findViewById(R.id.progressBar);

        textConteudo.setVisibility(View.GONE);

        new Thread(new Runnable() {
            @Override
            public void run() {

                SystemClock.sleep(5000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        exibirConteudo();
                    }
                });
            }
        }).start();
    }

    public void exibirConteudo () {

        textConteudo.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

}
