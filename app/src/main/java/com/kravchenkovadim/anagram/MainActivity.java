package com.kravchenkovadim.anagram;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

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

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.orange));


        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        binding.ConvertButton.setOnClickListener(v -> {
            String inputSymbols = binding.inputTextLayout.getText().toString();
            String filterString = binding.filterTextLayout.getText().toString();

            checkReadyToReverse(inputSymbols, filterString);
        });
        viewModel.getAnagram().
                observe(this, anagramText -> binding.outputResult.setText(anagramText));
    }

    private void checkReadyToReverse(String inputSymbols, String filterString) {
        boolean readyToReverse = true;
        if (hasDuplicateCharacters(filterString)) {
            binding.outputResult.setText(R.string.filter);
            readyToReverse = false;
        }
        if (filterString.contains(" ")) {
            binding.outputResult.setText(R.string.enter_symbols);
            readyToReverse = false;
        }
        if (inputSymbols.isEmpty()) {
            binding.outputResult.setText(R.string.enter_your_text);
            readyToReverse = false;
        }
        if (filterString.isEmpty()) {
            // add digit in filter
            filterString += getString(R.string.digit);
            // add special symbols in filter
            filterString += getString(R.string.symbols);
        }
        if (readyToReverse) {
            viewModel.insertAnagram(inputSymbols, filterString);
        }
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Проверяем, если клик был не по EditText, скрываем клавиатуру
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Получаем текущее фокусное поле
            View view = getCurrentFocus();
            if (view != null) {
                // Если есть фокус, скрываем клавиатуру
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        return super.onTouchEvent(event);
    }

}