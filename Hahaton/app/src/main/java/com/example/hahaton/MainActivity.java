package com.example.hahaton;

import android.content.Intent;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    // Объявление кнопок и текстового поля
    private TextView tvSelectedDate;
    private Button btnDay1, btnDay2, btnDay3, btnDay4, btnDay5, btnDay6, btnDay7;
    private FloatingActionButton btnAddEvent; // Плавающая кнопка добавления события
    private Button navButtonChat, navButtonHome, navButtonMero;
    private ImageButton navButtonSettings, navButtonCalendar; // Кнопки навигации
    private static final int ADD_EVENT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        btnDay1 = findViewById(R.id.btnDay1);
        btnDay2 = findViewById(R.id.btnDay2);
        btnDay3 = findViewById(R.id.btnDay3);
        btnDay4 = findViewById(R.id.btnDay4);
        btnDay5 = findViewById(R.id.btnDay5);
        btnDay6 = findViewById(R.id.btnDay6);
        btnDay7 = findViewById(R.id.btnDay7);
        btnAddEvent = findViewById(R.id.btnAddEvent); // Инициализация плавающей кнопки

        // Инициализация кнопок навигации
        navButtonChat = findViewById(R.id.nav_button_chat);
        navButtonHome = findViewById(R.id.nav_button_home);
        navButtonMero = findViewById(R.id.nav_button_mero);
        navButtonSettings = findViewById(R.id.btnSettings);
        navButtonCalendar = findViewById(R.id.btnCalendar);

        // Установка обработчиков для каждой кнопки
        btnDay1.setOnClickListener(view -> updateSelectedDate("21 октября"));
        btnDay2.setOnClickListener(view -> updateSelectedDate("22 октября"));
        btnDay3.setOnClickListener(view -> updateSelectedDate("23 октября"));
        btnDay4.setOnClickListener(view -> updateSelectedDate("24 октября"));
        btnDay5.setOnClickListener(view -> updateSelectedDate("25 октября"));
        btnDay6.setOnClickListener(view -> updateSelectedDate("26 октября"));
        btnDay7.setOnClickListener(view -> updateSelectedDate("27 октября"));

        // Обработчик нажатия на плавающую кнопку
        btnAddEvent.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEventActivity.class);
            startActivityForResult(intent, ADD_EVENT_REQUEST);
        });

        // Обработчики нажатий для кнопок навигации
        navButtonChat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivityIra.class);
            startActivity(intent);
        });
        // Обработчики нажатий для кнопок навигации
        navButtonMero.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivityVl.class);
            startActivity(intent);
        });
        // Обработчики нажатий для кнопок навигации
        navButtonSettings.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
        // Обработчики нажатий для кнопок навигации
        navButtonCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_EVENT_REQUEST && resultCode == RESULT_OK) {
            // Получение данных из интента
            String eventName = data.getStringExtra("eventName");
            String eventTime = data.getStringExtra("eventTime");
            String eventLocation = data.getStringExtra("eventLocation");

            // Добавление карточки события с переданными данными
            addEventCard(eventName, eventTime, eventLocation);
        }
    }

    // Метод для добавления карточки события
    private void addEventCard(String name, String time, String location) {
        // Получаем контейнер для карточек
        LinearLayout eventContainer = findViewById(R.id.eventContainer);

        // Создаем новую карточку
        View cardView = getLayoutInflater().inflate(R.layout.card_event, eventContainer, false);

        // Устанавливаем отступы для карточки
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(14, 12, 14, 18); // Отступы
        cardView.setLayoutParams(layoutParams);

        // Устанавливаем текст для карточки
        TextView tvEventName = cardView.findViewById(R.id.event);
        TextView tvEventTime = cardView.findViewById(R.id.eventTime);
        TextView tvEventLocation = cardView.findViewById(R.id.eventLocation);

        tvEventName.setText(name);
        tvEventTime.setText(time);
        tvEventLocation.setText(location);

        // Добавляем карточку в контейнер
        eventContainer.addView(cardView);
    }

    // Метод для обновления текста выбранной даты
    private void updateSelectedDate(String date) {
        tvSelectedDate.setText(date);
    }
}
