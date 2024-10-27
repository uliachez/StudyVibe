package com.example.hahaton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Switch switchNotifications;
    private SharedPreferences sharedPreferences;
    private Button navButtonChat, navButtonHome, navButtonMero;
    private ImageButton navbackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        switchNotifications = findViewById(R.id.switch_1);
        // Инициализация кнопок навигации
        navButtonChat = findViewById(R.id.nav_button_chat);
        navButtonHome = findViewById(R.id.nav_button_home);
        navButtonMero = findViewById(R.id.nav_button_mero);
        navbackButton = findViewById(R.id.backButton);

        // Устанавливаем текущее состояние Switch из SharedPreferences
        boolean isNotificationsEnabled = sharedPreferences.getBoolean("notifications_enabled", false);
        switchNotifications.setChecked(isNotificationsEnabled);

        // Обработчики нажатий для кнопок навигации
        navButtonChat.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsActivity.this, MainActivityIra.class);
            startActivity(intent);
        });
        // Обработчики нажатий для кнопок навигации
        navButtonMero.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsActivity.this, MainActivityVl.class);
            startActivity(intent);
        });

        // Обработчики нажатий для кнопок навигации
        navButtonHome.setOnClickListener(v -> {
            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        switchNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Сохраняем состояние в SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("notifications_enabled", isChecked);
                editor.apply();

                // Уведомляем пользователя
                String message = isChecked ? "Уведомления включены" : "Уведомления выключены";
                Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        // Обработчик для кнопки "Назад"
        navbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Закрываем это активити
                finish();
            }
        });
    }

}
