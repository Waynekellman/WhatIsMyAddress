package com.nyc.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    private TextView textView01, textView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        textView01 = (TextView) findViewById(R.id.text1);
        textView02 = (TextView) findViewById(R.id.text2);

        textView01.setText(intent.getStringExtra("item"));
        textView02.setText(String.valueOf(intent.getStringExtra("item").length()));
    }
}
