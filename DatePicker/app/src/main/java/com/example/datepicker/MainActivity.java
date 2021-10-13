package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
//    Button datePickerbtn;
    TextView SelectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectedDate = findViewById(R.id.selected_date);

        //Initialize calendar
        Calendar calendar = Calendar.getInstance();

        //Get year
        int year = calendar.get(Calendar.YEAR);

        //Get month
        int month = calendar.get(Calendar.MONTH);

        //Get day
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        SelectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfmonth) {

                        //Store date in string
                        String sDate = dayOfmonth + "/" + (month + 1)+ "/" + year;

                        //Set date on text view
                        SelectedDate.setText(sDate);
                    }
                },year,month,day);

                //Disable past date
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                //Disable future date
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                //Show date picker dialog
                datePickerDialog.show();
            }
        });

    }

}