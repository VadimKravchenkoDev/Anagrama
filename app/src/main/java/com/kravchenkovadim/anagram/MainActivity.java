package com.kravchenkovadim.anagram;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.kravchenkovadim.anagram.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.orange));


        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        binding.ConvertButton.setOnClickListener(v -> {
            String inputSymbols = binding.inputTextLayout.getText().toString();
            String filterString = binding.filterTextLayout.getText().toString();
            if (hasDuplicateCharacters(filterString)) {
                binding.outputResult.setText(R.string.filter);
            } else if (inputSymbols.isEmpty()) {
                binding.outputResult.setText(R.string.enter_your_text);
                if (filterString.contains(" ")) {
                    binding.outputResult.setText(R.string.enter_symbols);
                }
                if (filterString.isEmpty()) {
                    // add digit in filter
                    for (char ch = '0'; ch <= '9'; ch++) {
                        filterString += ch;
                    }
                    // add special symbols in filter
                    filterString += R.string.symbols;
                }
            } else viewModel.insertAnagram(inputSymbols, filterString);
        });

        viewModel.getAnagram().
                observe(this, anagramText -> binding.outputResult.setText(anagramText));
    }

    private boolean hasDuplicateCharacters(String string) {
        Set<Character> seen = new HashSet<>();
        for (char ch : string.toCharArray()) {

            if (!seen.add(ch)) {
                return true;
            }
        }
        return false;
    }
}