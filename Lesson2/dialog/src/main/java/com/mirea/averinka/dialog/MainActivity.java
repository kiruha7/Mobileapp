package com.mirea.averinka.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
    }

    public void onClickAlertDialog(View view) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "alert");
    }

    public void onClickTimeDialog(View view) {
        MyTimeDialogFragment timeDialog = new MyTimeDialogFragment();
        timeDialog.show(getSupportFragmentManager(), "time");
    }

    public void onClickDateDialog(View view) {
        MyDateDialogFragment dateDialog = new MyDateDialogFragment();
        dateDialog.show(getSupportFragmentManager(), "date");
    }

    public void onClickProgressDialog(View view) {
        MyProgressDialogFragment progressDialog = new MyProgressDialogFragment();
        progressDialog.show(getSupportFragmentManager(), "progress");
    }

    public void onOkClicked() {
        String message = "Вы выбрали кнопку \"Иду дальше\"!";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        textViewResult.setText(message);
    }

    public void onNeutralClicked() {
        String message = "Вы выбрали кнопку \"На паузе\"!";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        textViewResult.setText(message);
    }

    public void onCancelClicked() {
        String message = "Вы выбрали кнопку \"Нет\"!";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        textViewResult.setText(message);
    }
}