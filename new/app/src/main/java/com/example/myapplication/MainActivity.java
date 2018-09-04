package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonFragment.ChangeColorListener{

    private ColorFragment colorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.frang_color);
    }


    @Override
    public void changeColor(int color) {
        colorFragment.setColor(color);
    }
}
