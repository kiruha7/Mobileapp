package com.mirea.averinka.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBrowser(View view) {
        Uri address = Uri.parse("https://www.mirea.ru");
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(browserIntent);
    }

    public void onClickShare(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "МИРЭА");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "ФАМИЛИЯ ИМЯ ОТЧЕСТВО");
        startActivity(Intent.createChooser(shareIntent, "Аверин Кирилл Андреевич"));
    }
}