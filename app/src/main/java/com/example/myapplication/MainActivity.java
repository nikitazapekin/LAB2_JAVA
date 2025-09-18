package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

/*
package com.example.myapplication2332;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Button calculateButton;
    private TextView result10Days, result100Days, result1000Days;
    private SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        calculateButton = findViewById(R.id.calculateButton);
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


        calendar.add(Calendar.DAY_OF_MONTH, 10);

        Date date10Days = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 100);
        Date date100Days = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 1000);
        Date date1000Days = calendar.getTime();

        result10Days.setText("Через 10 дней: " + dateFormat.format(date10Days)  );
        result100Days.setText("Через 100 дней: " + dateFormat.format(date100Days));
        result1000Days.setText("Через 1000 дней: " + dateFormat.format(date1000Days));
    }
}
*/
/*
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/titleTextView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Выберите дату"
        android:textSize="20sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="24dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <DatePicker
        android:id="@+id/datePicker"
        android:layout_width="383dp"
        android:layout_height="318dp"
        android:datePickerMode="spinner"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/titleTextView" />

    <Button
        android:id="@+id/calculateButton"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="48dp"
        android:text="Рассчитать даты"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/datePicker" />

    <TextView
        android:id="@+id/result10Days"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Через 10 дней: "
        android:textSize="16sp"
        android:layout_marginBottom="16dp"
        android:gravity="center"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/calculateButton" />

    <TextView
        android:id="@+id/result100Days"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Через 100 дней: "
        android:textSize="16sp"
        android:layout_marginBottom="16dp"
        android:gravity="center"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/result10Days" />

    <TextView
        android:id="@+id/result1000Days"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Через 1000 дней: "
        android:textSize="16sp"
        android:gravity="center"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/result100Days" />

</androidx.constraintlayout.widget.ConstraintLayout>
 */