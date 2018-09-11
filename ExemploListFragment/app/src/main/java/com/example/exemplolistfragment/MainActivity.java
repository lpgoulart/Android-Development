package com.example.exemplolistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AlimentosFragment.OnItemClick {

    private TextFragment text_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_fragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.frag_text);
    }

    @Override
    public void onClick(Alimento alimento) {

        text_fragment.setText(String.format("O preco do %s eh %s", alimento.getNome(), alimento.getPreco()));

    }
}
