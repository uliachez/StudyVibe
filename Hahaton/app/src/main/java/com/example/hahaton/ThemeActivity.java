package com.example.hahaton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ThemeActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "ThemePrefs";
    private static final String THEME_KEY = "theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int themeMode = prefs.getInt(THEME_KEY, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        AppCompatDelegate.setDefaultNightMode(themeMode);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ToggleButton toggleLight = findViewById(R.id.circle_light);
        ToggleButton toggleDark = findViewById(R.id.circle_dark);

        // Установим состояние переключателей в зависимости от текущей темы
        toggleLight.setChecked(themeMode == AppCompatDelegate.MODE_NIGHT_NO);
        toggleDark.setChecked(themeMode == AppCompatDelegate.MODE_NIGHT_YES);

        toggleLight.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setAppTheme(AppCompatDelegate.MODE_NIGHT_NO);
                toggleDark.setChecked(false); // Убедимся, что темная тема выключена
            }
        });

        toggleDark.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setAppTheme(AppCompatDelegate.MODE_NIGHT_YES);
                toggleLight.setChecked(false); // Убедимся, что светлая тема выключена
            }
        });
    }

    private void setAppTheme(int mode) {
        AppCompatDelegate.setDefaultNightMode(mode);
        getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit().putInt(THEME_KEY, mode).apply();
        recreate(); // Пересоздаем активити для применения новой темы
    }
}
