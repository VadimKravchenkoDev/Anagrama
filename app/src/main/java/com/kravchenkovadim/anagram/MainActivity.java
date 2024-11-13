package com.kravchenkovadim.anagram;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.kravchenkovadim.anagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        binding.ConvertButton.setOnClickListener(v -> {
            String inputSymbols = binding.inputText.getText().toString();
            String filterString = binding.filterText.getText().toString();
            StringBuilder filter = new StringBuilder(filterString);
            viewModel.insertAnagram(inputSymbols, filter);
        });

        viewModel.getAnagram().observe(this, anagramText -> binding.outputResult.setText(anagramText));
    }
}