package com.mirea.averinka.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewResult = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        String time = intent.getStringExtra(MainActivity.EXTRA_TIME);
        int square = intent.getIntExtra(MainActivity.EXTRA_SQUARE, 0);
        String fio = intent.getStringExtra(MainActivity.EXTRA_FIO);
        String group = intent.getStringExtra(MainActivity.EXTRA_GROUP);

        String result = "ФИО: " + fio +
                "\nГруппа: " + group +
                "\nКвадрат значения моего номера по списку в группе составляет число " + square +
                ", а текущее время " + time;

        textViewResult.setText(result);
    }
}