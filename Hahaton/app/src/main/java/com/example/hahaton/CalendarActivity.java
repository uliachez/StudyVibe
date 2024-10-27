package com.example.hahaton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {
    private Button navButtonChat, navButtonHome, navButtonMero; // Кнопки навигации

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        CalendarView calendarView = findViewById(R.id.calendarView);

        // Инициализация кнопок навигации
        navButtonHome = findViewById(R.id.button_submit);

        navButtonHome.setOnClickListener(v -> {
            Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
            startActivity(intent);
        });
        // Установка слушателя для выбора даты
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Форматирование даты
                String date = dayOfMonth + "/" + (month + 1) + "/" + year; // Месяцы начинаются с 0
                Toast.makeText(CalendarActivity.this, "Выбранная дата: " + date, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
