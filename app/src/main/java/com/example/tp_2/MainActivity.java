package com.example.tp_2;

import android.os.Bundle;

import com.example.tp_2.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        String tituloCompuesto = R.string.title + " - " + R.string.groupNumber;
        setTitle(tituloCompuesto);
    }
}