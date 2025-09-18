package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button calculateButton;
    private Button backButton;
    private TextView result10Days, result100Days, result1000Days;
    private SimpleDateFormat dateFormat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        datePicker = findViewById(R.id.datePicker);
        calculateButton = findViewById(R.id.calculateButton);
        backButton = findViewById(R.id.backButton);
        result10Days = findViewById(R.id.result10Days);
        result100Days = findViewById(R.id.result100Days);
        result1000Days = findViewById(R.id.result1000Days);

        dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFutureDates();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрываем текущую активность и возвращаемся к предыдущей
            }
        });

        showCurrentDateResults();
    }

    private void showCurrentDateResults() {
        calculateFutureDates();
    }

    private void calculateFutureDates() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        // Расчет для 10 дней
        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date date10Days = calendar.getTime();

        // Расчет для 100 дней
        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_MONTH, 100);
        Date date100Days = calendar.getTime();

        // Расчет для 1000 дней
        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_MONTH, 1000);
        Date date1000Days = calendar.getTime();

        result10Days.setText("Через 10 дней: " + dateFormat.format(date10Days));
        result100Days.setText("Через 100 дней: " + dateFormat.format(date100Days));
        result1000Days.setText("Через 1000 дней: " + dateFormat.format(date1000Days));
    }
}