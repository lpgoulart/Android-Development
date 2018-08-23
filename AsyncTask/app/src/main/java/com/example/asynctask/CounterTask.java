package com.example.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class CounterTask extends AsyncTask <Integer, Integer, Void>{

    private Button button;
    private TextView txt;


    public CounterTask (TextView txt, Button btn) {
        this.button = btn;
        this.txt = txt;
    }

    @Override
    protected void onPreExecute() {
        button.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        button.setEnabled(true);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int c = values[0];
        txt.setText(String.valueOf(c));
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int max = params[0];
        for (int i =0; i<=max;i++) {
            SystemClock.sleep(1000);
            publishProgress(i);
        }
        return null;
    }
}
