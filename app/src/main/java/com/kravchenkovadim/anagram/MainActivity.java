package com.kravchenkovadim.anagram;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.kravchenkovadim.anagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AnagramViewModel anagramViewModel;

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
        anagramViewModel = new ViewModelProvider(this).get(AnagramViewModel.class);
        binding.ConvertButton.setOnClickListener(v -> {
            String inputSymbols = binding.inputText.getText().toString();
            String filterSymbols = binding.filterText.getText().toString();
            anagramViewModel.makeAnagram(inputSymbols, filterSymbols);
        });

        anagramViewModel.getAnagram().observe(this, anagramText -> binding.outputResult.setText(anagramText));
    }
}