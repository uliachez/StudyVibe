package com.example.hahaton;// MainActivity.java
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityVl extends AppCompatActivity {

    private boolean isFavorite = false; // Переменная для отслеживания состояния
    private Button navButtonChat, navButtonHome, navButtonMero; // Кнопки навигации

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vlad);

        // Обработка нажатия на сердце
        ImageButton heartButton1 = findViewById(R.id.heart1);
        ImageButton heartButton2 = findViewById(R.id.heart2);
        ImageButton heartButton3 = findViewById(R.id.heart3);// ID кнопки сердца

        // Инициализация кнопок навигации
        navButtonChat = findViewById(R.id.nav_button_chat);
        navButtonHome = findViewById(R.id.nav_button_home);

        // Обработчики нажатий для кнопок навигации
        navButtonHome.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityVl.this, MainActivity.class);
            startActivity(intent);
        });

        // Обработчики нажатий для кнопок навигации
        navButtonChat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityVl.this, MainActivityIra.class);
            startActivity(intent);
        });
        heartButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;  // Переключаем состояние

                // Меняем изображение сердца
                if (isFavorite) {
                    heartButton1.setImageResource(R.drawable.blackhearth);  // Черное сердце
                } else {
                    heartButton1.setImageResource(R.drawable.white);  // Белое сердце
                }
            }
        });
        heartButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;  // Переключаем состояние

                // Меняем изображение сердца
                if (isFavorite) {
                    heartButton2.setImageResource(R.drawable.blackhearth);  // Черное сердце
                } else {
                    heartButton2.setImageResource(R.drawable.white);  // Белое сердце
                }
            }
        });
        heartButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;  // Переключаем состояние

                // Меняем изображение сердца
                if (isFavorite) {
                    heartButton3.setImageResource(R.drawable.blackhearth);  // Черное сердце
                } else {
                    heartButton3.setImageResource(R.drawable.white);  // Белое сердце
                }
            }
        });

        // Обработка перехода на страницу избранных событий
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageButton favoritesButton = findViewById(R.id.hearth); // ID кнопки избранных

        favoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityVl.this, FavoritesActivity.class);
                startActivity(intent); // Переход на страницу избранных событий
            }
        });
    }
}
