package com.example.adapteproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapter.add("Natal");
        adapter.add("Fortaleza");
        adapter.add("Parnamirim");
        adapter.add("Recife");
        adapter.add("Ceara");

        spinner.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setOnItemClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String cidade = adapter.getItem(i);

        Toast.makeText(this,"Cidade selecionada:" + cidade, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
