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
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private Button btnStart, btnEnd, btnCalc;
    private TextView tvStart, tvEnd, tvResult;

    private Calendar startCal, endCal;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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
                finish();
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


        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date date10Days = calendar.getTime();


        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_MONTH, 100);
        Date date100Days = calendar.getTime();


        calendar.set(year, month, day);
        calendar.add(Calendar.DAY_OF_MONTH, 1000);
        Date date1000Days = calendar.getTime();

        result10Days.setText("Через 10 дней: " + dateFormat.format(date10Days));
        result100Days.setText("Через 100 дней: " + dateFormat.format(date100Days));
        result1000Days.setText("Через 1000 дней: " + dateFormat.format(date1000Days));
        btnStart = findViewById(R.id.btnStart);
        btnEnd   = findViewById(R.id.btnEnd);
        btnCalc  = findViewById(R.id.btnCalc);
        tvStart  = findViewById(R.id.tvStart);
        tvEnd    = findViewById(R.id.tvEnd);
        tvResult = findViewById(R.id.tvResult);

        btnStart.setOnClickListener(v -> showDatePicker(true));
        btnEnd.setOnClickListener(v -> showDatePicker(false));
        btnCalc.setOnClickListener(v -> calculateMondays());

    }

    private void showDatePicker(boolean isStart) {
        Calendar base = Calendar.getInstance();
        if (isStart && startCal != null) base = (Calendar) startCal.clone();
        if (!isStart && endCal != null)   base = (Calendar) endCal.clone();

        int y = base.get(Calendar.YEAR);
        int m = base.get(Calendar.MONTH);
        int d = base.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    Calendar chosen = Calendar.getInstance();
                    chosen.set(year, month, dayOfMonth, 0, 0, 0);

                    if (isStart) {
                        startCal = chosen;
                        tvStart.setText(sdf.format(chosen.getTime()));
                    } else {
                        endCal = chosen;
                        tvEnd.setText(sdf.format(chosen.getTime()));
                    }
                },
                y, m, d
        );
        dpd.show();
    }

    private void calculateMondays() {
        if (startCal == null || endCal == null) {
            Toast.makeText(this, "Выберите обе даты", Toast.LENGTH_SHORT).show();
            return;
        }

        Calendar startCalTemp = (Calendar) startCal.clone();
        Calendar endCalTemp = (Calendar) endCal.clone();

        if (startCalTemp.after(endCalTemp)) {
            Calendar tmp = startCalTemp; startCalTemp = endCalTemp; endCalTemp = tmp;
        }

        int count = countMondays(startCalTemp, endCalTemp);
        String msg = "Период: " + sdf.format(startCalTemp.getTime()) + " — " + sdf.format(endCalTemp.getTime())
                + "\nПонедельников: " + count;
        tvResult.setText(msg);
    }

    private static int countMondays(Calendar start, Calendar end) {
        Calendar cur = (Calendar) start.clone();
        int count = 0;
        while (!cur.after(end)) {
            if (cur.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) count++;
            cur.add(Calendar.DAY_OF_MONTH, 1);
        }
        return count;
    }
}