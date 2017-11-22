package com.nyc.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "address_shared_preferences";
    private EditText editText;
    private Button saveEmail, recyclerButton;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.email);
        saveEmail = (Button) findViewById(R.id.save_email);
        recyclerButton = (Button) findViewById(R.id.goto_recycler);

        saveEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(editText.getText().toString(),editText.getText().toString());
                editor.commit();
                editText.setText("");

            }
        });

        recyclerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("sharedpref", SHARED_PREFS_KEY);
                startActivity(intent);
            }
        });

    }
}
