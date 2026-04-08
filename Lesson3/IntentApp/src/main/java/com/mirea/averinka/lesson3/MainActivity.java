package com.mirea.averinka.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TIME = "extra_time";
    public static final String EXTRA_SQUARE = "extra_square";
    public static final String EXTRA_FIO = "extra_fio";
    public static final String EXTRA_GROUP = "extra_group";

    private static final int GROUP_NUMBER = 1;
    private static final String STUDENT_FIO = "Аверин Кирилл Андреевич";
    private static final String STUDENT_GROUP = "БСБО-50-24";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(v -> {
            long dateInMillis = System.currentTimeMillis();
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
            String dateString = sdf.format(new Date(dateInMillis));

            int square = GROUP_NUMBER * GROUP_NUMBER;

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(EXTRA_TIME, dateString);
            intent.putExtra(EXTRA_SQUARE, square);
            intent.putExtra(EXTRA_FIO, STUDENT_FIO);
            intent.putExtra(EXTRA_GROUP, STUDENT_GROUP);
            startActivity(intent);
        });
    }
}