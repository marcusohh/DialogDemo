package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    TextView tvDemo2;
    Button btnDemo3;
    TextView tvDemo3;
    Button btnExercise3;
    TextView tvExercise3;
    Button btnDemo4;
    TextView tvDemo4;
    Button btndemo5;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnExercise3 = findViewById(R.id.buttonExercise3);
        tvExercise3 = findViewById(R.id.textViewExercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btndemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        final Calendar now = Calendar.getInstance();

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /*
                myBuilder.setTitle("Demo 1 -Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close",null);
                */

                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("DISMISS",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select on of the Button below.");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Positive");
                    }
                });
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvDemo2.setText("You have selected Negative");
                    }
                });
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.sum, null);

                final EditText etsum1 = viewDialog.findViewById(R.id.editTextsum1);
                final EditText etsum2 = viewDialog.findViewById(R.id.editTextsum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String num1 = etsum1.getText().toString();
                        String num2 = etsum2.getText().toString();
                        final int mnum1=Integer.parseInt(num1);
                        final int mnum2=Integer.parseInt(num2);


                        Integer total = mnum1 + mnum2;

                        tvExercise3.setText("" + total);
                    }
                });
                myBuilder.setNegativeButton("CANCEL",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthofYear+1) + "/" + year);
                    }
                };

                Calendar now = Calendar.getInstance();  //Create a Calendar object with current date and time



                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener,now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }
        });
        btndemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker View, int hourofDay, int minute) {
                        tvDemo5.setText("Time " + hourofDay + ":" +minute);
                    }
                };


                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,myTimeListener,now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE),true);

                myTimeDialog.show();
            }
        });
    }
}
