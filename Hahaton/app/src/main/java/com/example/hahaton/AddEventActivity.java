package com.example.hahaton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class AddEventActivity extends AppCompatActivity {

    private EditText eventName;
    private EditText eventTime;
    private EditText eventLocation;
    private Button btnSaveEvent;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        // Инициализация элементов интерфейса
        eventName = findViewById(R.id.eventName);
        eventTime = findViewById(R.id.eventTime);
        eventLocation = findViewById(R.id.eventLocation);
        btnSaveEvent = findViewById(R.id.btnSaveEvent);
        backButton = findViewById(R.id.backButton);

        // Обработчик для кнопки "Добавить"
        btnSaveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eventName.getText().toString();
                String time = eventTime.getText().toString();
                String location = eventLocation.getText().toString();

                if (!name.isEmpty() && !time.isEmpty() && !location.isEmpty()) {
                    // Передаем данные обратно в MainActivity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("eventName", name);
                    resultIntent.putExtra("eventTime", time);
                    resultIntent.putExtra("eventLocation", location);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Toast.makeText(AddEventActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Обработчик для кнопки "Назад"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Закрываем это активити
                finish();
            }
        });
    }
}
