package com.example.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String messagename;
    String messagedob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AActivity.this,BActivity.class);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1)
            messagename = data.getStringExtra("name");
            messagedob = data.getStringExtra("dob");
            //textView.setText(message1);
            textView.setVisibility(View.VISIBLE);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setText("Name entered is "+messagename+" and date of birth is "+messagedob);
    }
}
