package com.example.hahaton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivityIra extends AppCompatActivity {
    private TextView text1, text2, text3, text4, text5, text6;
    private Button navButtonChat, navButtonHome, navButtonMero; // Кнопки навигации
    private String[] s1 = {
            "Будь активным участником занятий: задавай вопросы и участвуй в обсуждениях.",
            "Регулярно занимайся физической активностью, чтобы поддерживать уровень энергии и концентрацию.",
            "Используй образовательные приложения и онлайн-ресурсы для дополнительной практики и освоения новых тем.",
            "Используй активные методы изучения материала, такие как создание карточек с вопросами.",
            "Учись в тихом и удобном месте, свободным от отвлекающих факторов."
    };
    private String[] s2 = {
            "Общайся с более опытными участниками мероприятий, учись у них и делись своими идеями.",
            "Если ты не нашли подходящего кружка, создай его сам! Собирай единомышленников и организовывай что-то новое.",
            "Не забывай выделять время на отдых и восстановление сил между учебой и внеклассными мероприятиями.",
            "Посети музеи, выставки, исторические места или природные зоны, связанные с мероприятием.",
            "Организуй квесты, ориентированные на командную работу и решение задач."
    };
    private String[] s3 = {
            "Присоединяйся к клубам, секциям или группам по интересам, связанным с твоими хобби и увлечениями.",
            "Люди ценят искренность. Не пытайся казаться тем, кем ты не являешься.",
            "Проявляй интерес к другим: задавай вопросы о хобби, интересах и мнениях.",
            "Улыбайся и смотри людям в глаза. Это поможет создать положительное первое впечатление.",
            "Если тебе кто-то интересен, не стесняйся пригласить его на прогулку или просто пообщаться."
    };
    private int[] gradeMath, gradeEng, gradeRuss, gradeBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainira);

        Button btn1 = findViewById(R.id.button3);
        Button btn2 = findViewById(R.id.button5);
        Button btn3 = findViewById(R.id.btn1);
        Button btn4 = findViewById(R.id.btn2);
        Button btn5 = findViewById(R.id.btn3);

        text1=findViewById(R.id.textView3);
        text2=findViewById(R.id.textView5);
        text3=findViewById(R.id.textView6);
        text4=findViewById(R.id.textView8);
        text5=findViewById(R.id.textView9);
        text6=findViewById(R.id.textView7);

        // Инициализация кнопок навигации
        navButtonChat = findViewById(R.id.nav_button_chat);
        navButtonHome = findViewById(R.id.nav_button_home);
        navButtonMero = findViewById(R.id.nav_button_mero);

        gradeMath = new int[10];
        gradeEng = new int[10];
        gradeRuss = new int[10];
        gradeBio = new int[10];
        for (int i = 0; i<10;i++){
            Random random1 = new Random();
            gradeMath[i] = random1.nextInt(6);
            Random random2 = new Random();
            gradeEng[i] = random2.nextInt(6);
            Random random3 = new Random();
            gradeRuss[i] = random3.nextInt(6);
            Random random4 = new Random();
            gradeBio[i] = random4.nextInt(6);
        }

        // Обработчики нажатий для кнопок навигации
        navButtonHome.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityIra.this, MainActivity.class);
            startActivity(intent);
        });

        // Обработчики нажатий для кнопок навигации
        navButtonMero.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityIra.this, MainActivityVl.class);
            startActivity(intent);
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText(((Button) v).getText().toString());
                text1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        double o1=calculateAverage(gradeMath);
                        double o2=calculateAverage(gradeEng);
                        double o3=calculateAverage(gradeRuss);
                        double o4=calculateAverage(gradeBio);
                        String s = "В течение недели ты проявил активность на уроках и выполнил большинство заданий. Однако имеются некоторые области, требующие внимания.\nМатематика ";
                        s=s+String.valueOf(o1)+": "+getStr(o1)+"Английский "+String.valueOf(o2)+": "+getStr(o2)+"Русский язык "+String.valueOf(o3)+": "+getStr(o3)+"Биология "+String.valueOf(o4)+": "+getStr(o4);
                        text2.setText(s);
                        text2.setVisibility(View.VISIBLE);
                    }
                }, 1000 );

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text4.setText(((Button) v).getText().toString());
                text4.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        text3.setText(text3.getText().toString());
                        text3.setVisibility(View.VISIBLE);
                        btn3.setVisibility(View.VISIBLE);
                        btn4.setVisibility(View.VISIBLE);
                        btn5.setVisibility(View.VISIBLE);
                    }
                }, 500 );
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text5.setText("По улучшению успеваемости");
                text5.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int index = random.nextInt(s1.length);
                        text6.setText(s1[index]);
                        text6.setVisibility(View.VISIBLE);
                    }
                }, 500 );
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text5.setText("По внеклассным мероприятиям");
                text5.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int index = random.nextInt(s2.length);
                        text6.setText(s2[index]);
                        text6.setVisibility(View.VISIBLE);
                    }
                }, 500 );
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text5.setText("По поиску друзей");
                text5.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int index = random.nextInt(s3.length);
                        text6.setText(s3[index]);
                        text6.setVisibility(View.VISIBLE);
                    }
                }, 500 );
            }
        });

        }
    private double calculateAverage(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum / array.length;

    }
    private String getStr(double num) {
        if (num>=4.5 && num<=5){
            return "Молодец! Ты отлично поработал по этому предмету на этой неделe\n";
        }
        if (num>=3.5 && num<4.5){
            return "Ты хорошо поработал, но я уверен, что ты можешь лучше!\n";
        }
        if (num>=2.5 && num<3.5){
            return "Нужно подтянуть оценки по этому предмету. Ты всегда можешь получить совет по успеваемости от меня.\n";
        }
        if (num>=0 && num<2.5){
            return "Тебе нужна помощь. Посмотри мои советы по улучшению успеваемости или обратись к своему учителю\n";
        }
        return "";
    }
}
