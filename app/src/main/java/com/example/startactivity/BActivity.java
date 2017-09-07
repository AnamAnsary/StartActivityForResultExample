package com.example.startactivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by vmplapp on 7/9/17.
 */

public class BActivity extends AppCompatActivity {

    TextView textView;
    EditText name;
    Button btnsub;
    //DatePicker picker;
    Button btndob;
    private Calendar calendar;
    private int year, month, day;
    private String dateSelected;
    private static final String TAG = "BActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        name = (EditText) findViewById(R.id.name
        );
        textView = (TextView) findViewById(R.id.textView);
      //  picker=(DatePicker)findViewById(R.id.datePicker);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);


        btnsub = (Button) findViewById(R.id.btnsub);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* int day = picker.getDayOfMonth();
                int month =  (picker.getMonth() + 1);
                int year = picker.getYear();
*/
               if(name != null && dateSelected!=null) {
                   Intent i = new Intent();
                   i.putExtra("name", name.getText().toString());
                   i.putExtra("dob", dateSelected);
                   setResult(1, i);
                   finish();
               }
               else {
                   Toast.makeText(getApplicationContext(), "Empty Field!", Toast.LENGTH_SHORT).show();
               }

            }
        });

        btndob = (Button) findViewById(R.id.btndob);
        btndob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection deprecation
                showDialog(999);
            }
        });

    }

    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    dateSelected = arg3+"/"+(arg2+1)+"/"+arg1;
                    Log.w(TAG, "onDateSet: "+dateSelected );
                    //showDate(arg1, arg2+1, arg3);
                }
            };
}