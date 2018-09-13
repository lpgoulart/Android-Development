package com.example.exemplodialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {

        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "dialog");

    }

    public void openSimple(View view) {

        SimpleDialogFragment simpleDialog = new SimpleDialogFragment();
        simpleDialog.show(getSupportFragmentManager(),"simpleDialog");

    }

    public void openRadio(View view) {

        RadioDialogFragment radioDialog = new RadioDialogFragment();
        radioDialog.show(getSupportFragmentManager(), "radioDialog");

    }
}
