package com.mirea.averinka.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    private TextView textViewDeveloperBook;
    private TextView textViewDeveloperQuote;
    private TextView textViewStudentInfo;
    private EditText editTextUserBook;
    private EditText editTextUserQuote;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        textViewDeveloperBook = findViewById(R.id.textViewDeveloperBook);
        textViewDeveloperQuote = findViewById(R.id.textViewDeveloperQuote);
        textViewStudentInfo = findViewById(R.id.textViewStudentInfo);
        editTextUserBook = findViewById(R.id.editTextUserBook);
        editTextUserQuote = findViewById(R.id.editTextUserQuote);
        buttonSend = findViewById(R.id.buttonSend);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String bookName = extras.getString(MainActivity.BOOK_NAME_KEY);
            String quoteName = extras.getString(MainActivity.QUOTES_KEY);
            String fio = extras.getString(MainActivity.FIO_KEY);
            String group = extras.getString(MainActivity.GROUP_KEY);

            textViewDeveloperBook.setText("Любимая книга разработчика: " + bookName);
            textViewDeveloperQuote.setText("Цитата из книги: " + quoteName);
            textViewStudentInfo.setText("Студент: " + fio + "\nГруппа: " + group);
        }

        buttonSend.setOnClickListener(v -> {
            String userBook = editTextUserBook.getText().toString().trim();
            String userQuote = editTextUserQuote.getText().toString().trim();

            String text = "Студент: Аверин Кирилл Андреевич" +
                    "\nГруппа: БСБО-50-24" +
                    "\nНазвание Вашей любимой книги: " + userBook +
                    "\nЦитата: " + userQuote;

            Intent data = new Intent();
            data.putExtra(MainActivity.USER_MESSAGE, text);
            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }
}