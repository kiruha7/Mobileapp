package com.mirea.averinka.buttonclicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvOut;
    private Button btnWhoAmI;
    private Button btnItsNotMe;
    private CheckBox cbFlag;

    private final int STUDENT_NUMBER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItsNotMe = findViewById(R.id.btnItsNotMe);
        cbFlag = findViewById(R.id.cbFlag);

        btnWhoAmI.setOnClickListener(v -> {
            tvOut.setText("Мой номер по списку № " + STUDENT_NUMBER);
            cbFlag.setChecked(true);
        });
    }

    public void onItsNotMeClick(View view) {
        tvOut.setText("Это не я сделал...");
        cbFlag.setChecked(false);
    }
}