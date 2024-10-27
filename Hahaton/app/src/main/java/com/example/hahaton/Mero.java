package com.example.hahaton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class Mero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button navButtonMero = findViewById(R.id.nav_button_mero);
        navButtonMero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mero.this, MainActivity.class); // Убедитесь, что MeroActivity правильно названа
                startActivity(intent);
            }
        });
    }
}
