package com.mirea.averinka.favoritebook;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> activityResultLauncher;

    public static final String BOOK_NAME_KEY = "book_name";
    public static final String QUOTES_KEY = "quotes_name";
    public static final String USER_MESSAGE = "MESSAGE";
    public static final String FIO_KEY = "fio_key";
    public static final String GROUP_KEY = "group_key";

    private TextView textViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewBook = findViewById(R.id.textViewBook);

        ActivityResultCallback<ActivityResult> callback = result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                    String userBook = data.getStringExtra(USER_MESSAGE);
                    textViewBook.setText(userBook);
                }
            }
        };

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                callback
        );
    }

    public void getInfoAboutBook(View view) {
        Intent intent = new Intent(this, ShareActivity.class);

        intent.putExtra(BOOK_NAME_KEY, "Мастер и Маргарита");
        intent.putExtra(QUOTES_KEY, "Рукописи не горят.");
        intent.putExtra(FIO_KEY, "Аверин Кирилл Андреевич");
        intent.putExtra(GROUP_KEY, "БСБО-50-24");

        activityResultLauncher.launch(intent);
    }
}