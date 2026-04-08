package com.mirea.averinka.sharer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    private TextView textViewSharedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        textViewSharedData = findViewById(R.id.textViewSharedData);
        handleSendIntent(getIntent());
    }

    private void handleSendIntent(Intent intent) {
        if (intent == null) {
            textViewSharedData.setText("Данные не получены");
            return;
        }

        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    textViewSharedData.setText("Получен текст:\n\n" + sharedText);
                } else {
                    textViewSharedData.setText("Текст не передан");
                }
            } else if (type.startsWith("image/")) {
                Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri != null) {
                    textViewSharedData.setText("Получено изображение:\n\n" + imageUri);
                } else {
                    textViewSharedData.setText("Изображение не передано");
                }
            } else {
                textViewSharedData.setText("Неподдерживаемый тип данных: " + type);
            }
        } else {
            textViewSharedData.setText("Приложение открыто без ACTION_SEND");
        }
    }
}